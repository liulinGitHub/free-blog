package com.blog.core.system.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @ClassNmae: ResourceServerConfigurer
 * @description:
 * @Author: liulin
 * @Date: 2019/10/27 17:46
 **/
@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/oauth/**",
                        "/admin/user/info",
                        "/admin/menu/userMenu",
                        "/*/swagger-ui.html",
                        "/*/swagger-resources/**",
                        "/*/v2/api-docs",
                        "/*/swagger/api-docs",
                        "/*/webjars/**").permitAll()
                .anyRequest()
                .authenticated();
    }
}
