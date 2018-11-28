package com.tingkelai;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 听客来shiro权限控制模块入口
 * 在该模块会进行认证授权等操作
 *
 * 2018-11-23 16:13:03
 * @author liuzhengjie
 * @version 1.0
 */
@SpringBootApplication
public class TklShiroApplication {

	private static Logger logger = LoggerFactory.getLogger(TklShiroApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai shiro module start");
		System.out.println("========== 听客来shiro模块启动 ===========");
		SpringApplication.run(TklShiroApplication.class, args);
		System.out.println("======== 听客来shiro模块启动完成！ ===========");
	}
}
