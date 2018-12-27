package com.tingkelai;

import com.tingkelai.config.env.EnvConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklSmsApplication {

	private static Logger logger = LoggerFactory.getLogger(TklSmsApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
		SpringApplication springApplication = new SpringApplication(TklSmsApplication.class);
		springApplication.setDefaultProperties(EnvConfig.getProperties());
		springApplication.run(args);
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
	}
}
