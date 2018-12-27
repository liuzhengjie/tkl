package com.tingkelai.config.env;

import com.tingkelai.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

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
        return resSet.toArray(new String[0]);
    }

    public static Properties getProperties() {
        logger.info("====配置文件路径：" + GlobalConfig.CONFIG_ROOT_PATH);
        Properties properties = new Properties();
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
}
