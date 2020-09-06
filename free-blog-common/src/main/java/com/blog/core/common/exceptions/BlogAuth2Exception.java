package com.blog.core.common.exceptions;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020-04-10 14:26
 * @version: 1.0
 */
public class BlogAuth2Exception extends OAuth2Exception {

    public BlogAuth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogAuth2Exception(String message) {
        super(message);
    }
}
