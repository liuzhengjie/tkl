package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 系统设置模块入口
 * 2018-11-23 14:37:47
 * @author liuzhengjie
 * @version 1.0
 */
@SpringBootApplication
@ServletComponentScan
public class TklSysApplication {

	private static Logger logger = LoggerFactory.getLogger(TklSysApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai sys module start");
		System.out.println("========== 听客来sys模块启动 ===========");
		SpringApplication.run(TklSysApplication.class, args);
		System.out.println("======== 听客来sys模块启动成功 ===========");
	}
}
