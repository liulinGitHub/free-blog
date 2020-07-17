package com.blog.core.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: TaskHandHandler
 * @description: 任务处理注解
 * @author: liulin
 * @create: 2020-06-15 09:49
 * @Version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TaskHandHandler {

	String type();
}
