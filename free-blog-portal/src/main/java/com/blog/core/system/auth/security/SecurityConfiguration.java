package com.blog.core.system.auth.security;

import com.blog.core.system.auth.filter.CustomizeFilterSecurityInterceptor;
import com.blog.core.system.auth.impl.CustomFilterInvocationSecurityMetadataSource;
import com.blog.core.system.user.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ClassNmae: SecurityConfiguration
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:57
 **/

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeFilterSecurityInterceptor customizeFilterSecurityInterceptor;

    @Autowired
    private CustomizeUserDetailsService customizeUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                //过滤oauth
                .antMatchers("/oauth/**").permitAll()
                //过滤首页
                .antMatchers("/").permitAll()
                // swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated();

        http.addFilterBefore(customizeFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        auth.userDetailsService(customizeUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Bean
//    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
//        return new CustomFilterInvocationSecurityMetadataSource();
//    }
}
