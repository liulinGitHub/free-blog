package com.blog.core;

import com.blog.core.common.interceptor.ResponseResultInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @program: FreeBlogManageApplication
 * @description: 后台管理系统启动类
 * @author: liulin
 * @create: 2019-10-24 10:03
 * @Version: 1.0
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.blog.core.**.dao")
public class FreeBlogManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeBlogManageApplication.class, args);
    }
}
