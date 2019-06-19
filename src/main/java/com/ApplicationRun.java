package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-16 15:06
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.daka.webserver.dao")
@ServletComponentScan("com.daka.core.listener")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}