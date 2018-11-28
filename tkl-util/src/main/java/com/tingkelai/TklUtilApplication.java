package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 听客来util模块入口，包含常用工具类，常量类等
 * 2018-11-23 16:01:44
 * @author liuzhengjie
 * @version 1.0
 */
@SpringBootApplication
public class TklUtilApplication {

	private static Logger logger = LoggerFactory.getLogger(TklUtilApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai util module start");
		System.out.println("========== 听客来util模块启动 ===========");
		SpringApplication.run(TklUtilApplication.class, args);
		System.out.println("======== 听客来util模块启动完成 ===========");
	}
}
