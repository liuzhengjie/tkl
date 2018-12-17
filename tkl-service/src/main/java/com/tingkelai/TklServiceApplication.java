package com.tingkelai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "com.tingkelai.**" })
@MapperScan(basePackages = "com.tingkelai.dao")
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class TklServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TklServiceApplication.class, args);
	}
}
