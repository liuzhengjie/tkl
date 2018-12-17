package com.tingkelai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TklServiceApplicationTest {

    public static void main(String[] args) {
        System.out.println("====启动开始====");
        SpringApplication.run(TklServiceApplication.class, args);
        System.out.println("====启动完毕====");
    }
}