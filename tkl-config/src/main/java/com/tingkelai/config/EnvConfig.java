package com.tingkelai.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;
import java.util.Properties;

/**
 * 初始化系统环境变量
 * 2018-12-25 16:08:56
 * @author liuzhengjie
 * @version 1.0
 */
@Configuration
public class EnvConfig implements EnvironmentAware{
    @Override
    public void setEnvironment(Environment environment) {
        Properties properties = new Properties();
        // 遍历配置文件路径下的所有yml/yaml/properties开头的文件，读取作为config
//        File file = new File(GlobalConfigUtil.CONFIG_ROOT_PATH);
    }
}
