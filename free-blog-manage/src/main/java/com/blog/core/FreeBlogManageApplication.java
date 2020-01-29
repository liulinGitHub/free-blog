package com.blog.core;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: FreeBlogManageApplication
 * @description: 后台管理系统启动类
 * @author: liulin
 * @create: 2019-10-24 10:03
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.blog.core.**.dao")
public class FreeBlogManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeBlogManageApplication.class, args);
    }
}
