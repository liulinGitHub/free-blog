package com.blog.core.common.exceptions;

/**
 * @description: 运行异常
 * @author: 950103
 * @create_time: 2019-05-27 09:18
 * @version: 1.0
 */
public class BlogRuntimeException extends RuntimeException {

    public BlogRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogRuntimeException(String message) {
        super(message);
    }
}
