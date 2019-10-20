package com.blog.core.common.aspect;


import org.springframework.stereotype.Component;

/**
 * @program: RequestHolder
 * @description: threadLocal处理类
 * @author: liulin
 * @create: 2019-05-16 11:06
 * @Version: 1.0
 */
@Component
public class RequestHolder {

    private static final ThreadLocal<Object> userHolder = new ThreadLocal<Object>();

    public static void add(Object object) {
        userHolder.set(object);
    }

    public static Object get() {
        return userHolder.get();
    }

    public static void remove() {
        userHolder.remove();
    }
}