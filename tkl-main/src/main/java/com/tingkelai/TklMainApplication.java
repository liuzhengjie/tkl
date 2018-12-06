package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklMainApplication {

	private static Logger logger = LoggerFactory.getLogger(TklMainApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
		SpringApplication.run(TklMainApplication.class, args);
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
	}
}
