package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklProductApplication {

	private static Logger logger = LoggerFactory.getLogger(TklProductApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai product module start");
		System.out.println("========== 听客来product模块启动 ===========");
		SpringApplication.run(TklProductApplication.class, args);
		System.out.println("========== 听客来product模块启动 ===========");
	}
}
