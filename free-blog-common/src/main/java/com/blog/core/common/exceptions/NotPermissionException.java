package com.blog.core.common.exceptions;

/**
 * @program: NotPermissionException
 * @description: 访问权限不足
 * @author: liulin
 * @create: 2019-10-30 17:36
 * @Version: 1.0
 */
public class NotPermissionException extends RuntimeException {

    public NotPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPermissionException(String message) {
        super(message);
    }
}
