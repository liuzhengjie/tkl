package com.tingkelai;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 系统config模块入口
 * 2018-11-23 14:37:09
 * @author liuzhengjie
 * @version 1.0
 */
@ComponentScan(basePackages = { "com.tingkelai.**" })
@MapperScan(basePackages = "com.tingkelai.dao")
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class TklConfigApplication {

	private static Logger logger = LoggerFactory.getLogger(TklConfigApplication.class);

	public static void main(String[] args) {
		logger.debug("====tingkelai config module start");
		System.out.println("========== 听客来config模块启动 ===========");
		SpringApplication.run(TklConfigApplication.class, args);
		System.out.println("======== 听客来config模块启动成功！ ===========");
	}

	/**
	 * 乐观锁插件
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
		return new OptimisticLockerInterceptor();
	}
}
