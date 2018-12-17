package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklCustomerApplication {

	private static Logger logger = LoggerFactory.getLogger(TklCustomerApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai sys module start");
		System.out.println("========== 听客来customer模块启动 ===========");
		SpringApplication.run(TklCustomerApplication.class, args);
		System.out.println("========== 听客来customer模块启动 ===========");
	}
}
