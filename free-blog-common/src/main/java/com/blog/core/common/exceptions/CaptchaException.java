package com.blog.core.common.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description: 验证码异常
 * @author: 950103
 * @create_time: 2020/9/6 18:31
 * @version 1.0
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(String message) {
        super(message);
    }
}
