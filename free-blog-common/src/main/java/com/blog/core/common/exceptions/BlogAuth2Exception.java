package com.blog.core.common.exceptions;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @program: ContomAccessDeniedException
 * @description:
 * @author: liulin
 * @create: 2020-04-10 14:26
 * @Version: 1.0
 */
public class BlogAuth2Exception extends OAuth2Exception {


    public BlogAuth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogAuth2Exception(String message) {
        super(message);
    }
}
