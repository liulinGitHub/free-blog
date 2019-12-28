package com.blog.core.system.auth.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassNmae: SecurityConfiguration
 * @description: Security配置类
 * @Author: liulin
 * @Date: 2019/11/24 23:38
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                    "/actuator/**",
                    "/token/**").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable();
    }

}
