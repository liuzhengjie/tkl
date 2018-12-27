package com.tingkelai.util.env;

import org.apache.commons.codec.Charsets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

/**
 * 全局环境变量读取配置
 * 2018-12-26 17:29:16
 * @author liuzhengjie
 * @version 1.0
 */
public class GlobalConfig {

    /**
     * 从系统的环境变量中寻找该名称的环境变量，作为配置文件所在的根路径
     */
    private static final String ENV_CONFIG_PATH_NAME = "TKL_CONFIG_PATH";

    /**
     * 开发环境下的配置文件根路径，如果不存在ENVIRONMENT_VARIABLE_NAME的环境变量，那么就是用这个变量
     */
    private static final String DEFAULT_CONFIG_ROOT_PATH = "";

    /**
     * 使用默认的环境变量
     */
    public static String CONFIG_ROOT_PATH = DEFAULT_CONFIG_ROOT_PATH;

    /**
     * 如果存在ENVIRONMENT_VARIABLE_NAME的环境变量，那么就使用ENVIRONMENT_VARIABLE_NAME
     */
    static {
        Map<String, String> envMap = System.getenv();
        String envRoot = envMap.get(ENV_CONFIG_PATH_NAME);
        if (envRoot != null) {
            CONFIG_ROOT_PATH = envRoot;
        }
    }

    /**
     * 从指定path加载配置文件。
     * 如果RISHIQING_BACK_END_CONFIG_PATH环境变量存在，那么就现在这个环境变量的路径下找
     * 否则，从默认路径DEFAULT_CONFIG_ROOT_PATH下找
     * @param absolutePath 绝对路径
     * @return properties对象
     * @throws IOException 异常
     */
    public static Properties load(String absolutePath) throws IOException {
        Properties props = new Properties();
        return load(absolutePath, props);
    }

    /**
     * 从指定path加载配置文件，并且装入originProperties中
     * 如果RISHIQING_BACK_END_CONFIG_PATH环境变量存在，那么就现在这个环境变量的路径下找
     * 否则，从默认路径DEFAULT_CONFIG_ROOT_PATH下找
     * @param absolutePath 绝对路径
     * @param originProperties 文件
     * @return properties对象
     * @throws IOException 异常
     */
    public static Properties load(String absolutePath, Properties originProperties) throws IOException {
        InputStream configInput = new FileInputStream(absolutePath);
        originProperties.load(new InputStreamReader(configInput, Charsets.UTF_8));
        return originProperties;
    }
}
