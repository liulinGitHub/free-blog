package com.blog.core.common.exceptions;

/**
 * @ClassName: DataNotFoundException
 * @description: 数据未找到
 * @author: 950103
 * @create: 2019-05-04 17:54
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
