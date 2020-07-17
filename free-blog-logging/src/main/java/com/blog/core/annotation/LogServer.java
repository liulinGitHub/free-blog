package com.blog.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ServerLog
 * @description: 自定义日志注解
 * @author: 950103
 * @create: 2019-04-08 19:35
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogServer {

    String value() default "";

    String type() default "";
}
