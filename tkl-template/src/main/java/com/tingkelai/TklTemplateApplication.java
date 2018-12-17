package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklTemplateApplication {

	private static Logger logger = LoggerFactory.getLogger(TklTemplateApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai template module start");
		System.out.println("========== 听客来customer模块启动 ===========");
		SpringApplication.run(TklTemplateApplication.class, args);
		System.out.println("========== 听客来customer模块启动 ===========");
	}

}

