package com.blog.core.system.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @program: CusAuthenticationManager
 * @description:
 * @author: liulin
 * @create: 2019-12-24 14:18
 * @Version: 1.0
 */
@Component
public class CusAuthenticationManager implements AuthenticationManager {

    @Autowired
    private CustomizeAuthenticationProvider customizeAuthenticationProvider;

    public CusAuthenticationManager(CustomizeAuthenticationProvider customizeAuthenticationProvider) {
        this.customizeAuthenticationProvider = customizeAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication result = customizeAuthenticationProvider.authenticate(authentication);
        if (Objects.nonNull(result)) {
            return result;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}
