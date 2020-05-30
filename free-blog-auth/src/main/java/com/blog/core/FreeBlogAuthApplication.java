package com.blog.core;

import org.apache.rocketmq.client.log.ClientLogger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @program: FreeBlogAuthApplication
 * @description: 权限模块
 * @author: liulin
 * @create: 2020-05-29 16:42
 * @Version: 1.0
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.blog.core.**.dao")
public class FreeBlogAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeBlogAuthApplication.class, args);
		System.setProperty(ClientLogger.CLIENT_LOG_USESLF4J, "true");
	}
}
