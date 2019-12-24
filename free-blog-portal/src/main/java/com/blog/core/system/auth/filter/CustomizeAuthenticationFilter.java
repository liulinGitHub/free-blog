package com.blog.core.system.auth.filter;

import com.blog.core.system.user.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: CustomizeAuthenticationFilter
 * @description:
 * @author: liulin
 * @create: 2019-12-24 11:49
 * @Version: 1.0
 */
@Component
public class CustomizeAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomizeUserDetailsService customizeUserDetailsService;

    protected CustomizeAuthenticationFilter(CustomizeUserDetailsService customizeUserDetailsService) {
        this.customizeUserDetailsService = customizeUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
