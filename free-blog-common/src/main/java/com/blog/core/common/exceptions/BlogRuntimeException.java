package com.blog.core.common.exceptions;

/**
 * @ClassName: BlogRuntimeException
 * @description: 运行异常
 * @author: 950103
 * @create: 2019-05-27 09:18
 * @Version: 1.0
 */
public class BlogRuntimeException extends RuntimeException {

    public BlogRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogRuntimeException(String message) {
        super(message);
    }
}
