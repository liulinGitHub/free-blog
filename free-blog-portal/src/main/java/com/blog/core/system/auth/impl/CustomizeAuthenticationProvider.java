package com.blog.core.system.auth.impl;

import com.blog.core.system.user.entity.domain.SecurityUserDetails;
import com.blog.core.system.user.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @program: CustomizeAuthenticationProvider
 * @description: 自定义认证处理
 * @author: liulin
 * @create: 2019-12-23 18:01
 * @Version: 1.0
 */
@Component
public class CustomizeAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomizeUserDetailsService customizeUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SecurityUserDetails securityUserDetails = (SecurityUserDetails) customizeUserDetailsService.loadUserByUsername(userName);
        if(!securityUserDetails.getPassword().equals(password)){
            throw new BadCredentialsException("密码错误！");
        }
        return new UsernamePasswordAuthenticationToken(securityUserDetails, password, securityUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
