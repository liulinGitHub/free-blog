package com.blog.core.common.exceptions;

/**
 * @description: token异常
 * @author: 950103
 * @create_time: 2019-05-16 17:42
 * @version: 1.0
 */
public class TokenException extends RuntimeException {

    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenException(String message) {
        super(message);
    }
}
