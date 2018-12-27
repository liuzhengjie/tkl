package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 打包专用
 * 2018-12-24 16:27:32
 * @author liuzhengjie
 * @version 1.0
 */
@SpringBootApplication
public class TklPackageApplication extends SpringBootServletInitializer{

	private static Logger logger = LoggerFactory.getLogger(TklPackageApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TklPackageApplication.class);
	}

	public static void main(String[] args) {
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
		SpringApplication springApplication = new SpringApplication(TklPackageApplication.class);
//		springApplication.setDefaultProperties(EnvConfig.getProperties());
		springApplication.run(args);
		logger.debug("====tingkelai start");
		System.out.println("========== 听客来系统启动 ===========");
	}

}

