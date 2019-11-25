package com.blog.core.system.auth.security;

import com.blog.core.system.auth.utils.CustomFilterInvocationSecurityMetadataSource;
import com.blog.core.system.auth.utils.CustomizeAccessDecisionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ClassNmae: SecurityConfiguration
 * @description: Security配置类
 * @Author: liulin
 * @Date: 2019/11/24 23:38
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

    @Autowired
    private CustomizeAccessDecisionManager customizeAccessDecisionManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>(){

                @Override
                public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                    object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                    object.setAccessDecisionManager(customizeAccessDecisionManager);
                    return object;
                }
            });

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/oauth/**", "/swagger-ui.html", "/swagger-resources", "/v2/api-docs");
    }
}
