package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统api模块入口，接口文档由swagger实现
 * 2018-11-23 14:05:27
 * @author liuzhengjie
 * @version 1.0
 */
@SpringBootApplication
@EnableSwagger2
public class TklApiApplication {

    private static Logger logger = LoggerFactory.getLogger(TklApiApplication.class);

    public static void main(String[] args){
        logger.debug("====tingkelai api module start");
        System.out.println("========== 听客来api模块启动 ===========");
        SpringApplication.run(TklApiApplication.class, args);
        System.out.println("======== 听客来api模块启动成功！ ===========");
    }
}
