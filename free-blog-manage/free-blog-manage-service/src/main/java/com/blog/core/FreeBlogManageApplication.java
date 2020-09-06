package com.blog.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description: 后台管理系统启动类
 * @author: 950103
 * @create_time: 2019-10-24 10:03
 * @version: 1.0
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.blog.core.**.dao")
public class FreeBlogManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeBlogManageApplication.class, args);
    }
}
