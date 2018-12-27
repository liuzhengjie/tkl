package com.tingkelai.util.env;

import com.tingkelai.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * 初始化系统环境变量
 * 2018-12-25 16:08:56
 * @author liuzhengjie
 * @version 1.0
 */
public class EnvConfig{

    private static Logger logger = LoggerFactory.getLogger(EnvConfig.class);

    private static Properties properties = new Properties();

    public static String[] getEnvArgs(){
        // 设置返回值
        Set<String> resSet = new HashSet<>();
        // 读取配置值
        Properties properties = getProperties();
        Set<String> set = properties.stringPropertyNames();
        for(String temp : set){
            String value = properties.getProperty(temp);
            if(value != null && value.length() > 0){
                String envStr = "--" + temp + "=" + value;
                resSet.add(envStr);
            }
        }
        logger.info(resSet + "");
        return resSet.toArray(new String[0]);
    }

    private synchronized  static Properties getProperties() {
        logger.info("====配置文件路径：" + GlobalConfig.CONFIG_ROOT_PATH);
        try {
            List<File> fileList = new ArrayList<>();
            fileList = FileUtil.getFileList(GlobalConfig.CONFIG_ROOT_PATH, fileList);
            for(File file : fileList){
                String fileName = file.getName();
                if(fileName.endsWith(".yml") || fileName.endsWith(".yaml") || fileName.endsWith(".properties")){
                    String configPath = file.getPath();
                    GlobalConfig.load(configPath, properties);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    /** 获取配置值,string */
    public static String getPropertyString(String key) {
        if (null == properties) {
            properties = getProperties();
        }
        return properties.getProperty(key);
    }

    /** 获取配置值, long */
    public static Long getPropertyLong(String key) {
        try{
            if (null == properties) {
                properties = getProperties();
            }
            if(properties.getProperty(key) != null){
                return Long.parseLong(properties.getProperty(key));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

    /** 获取配置值, integer */
    public static Integer getPropertyInteger(String key) {
        try{
            if (null == properties) {
                properties = getProperties();
            }
            if(properties.getProperty(key) != null){
                return Integer.parseInt(properties.getProperty(key));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return 0;
    }

    /** 获取配置值, boolean */
    public static Boolean getPropertyBoolean(String key) {
        try{
            if (null == properties) {
                properties = getProperties();
            }
            if(properties.getProperty(key) != null){
                return Boolean.parseBoolean(properties.getProperty(key));
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return true;
    }
}
