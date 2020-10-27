package com.blog.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description: 前台页面展示系统启动类
 * @author: 950103
 * @create_time: 2019-10-09 16:51
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.blog.core.**.dao")
@EnableCaching
public class FreeBlogPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeBlogPortalApplication.class, args);
    }
}
