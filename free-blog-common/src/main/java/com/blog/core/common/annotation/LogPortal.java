package com.blog.core.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: LogPortal
 * @description: 自定义日志注解
 * @author: 950103
 * @create: 2019-04-08 19:35
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogPortal {
    String value() default "";
}
