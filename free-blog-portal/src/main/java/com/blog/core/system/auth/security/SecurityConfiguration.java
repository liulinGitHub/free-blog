package com.blog.core.system.auth.security;

import com.blog.core.system.auth.filter.CustomizeAuthenticationProcessingFilter;
import com.blog.core.system.auth.impl.CustomFilterInvocationSecurityMetadataSource;
import com.blog.core.system.auth.impl.CustomizeAccessDecisionManager;
import com.blog.core.system.user.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassNmae: SecurityConfiguration
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:57
 **/

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeUserDetailsService customizeUserDetailsService;

    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

    @Autowired
    private CustomizeAccessDecisionManager customizeAccessDecisionManager;

    @Autowired
    private CustomizeAuthenticationProcessingFilter customizeAuthenticationProcessingFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();

        // 禁用CSRF 开启跨域
        http.csrf().disable().cors();


        registry.and().rememberMe();

        // 其余所有请求都需要认证
        registry.anyRequest().authenticated();

        // url权限认证处理
        registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                o.setAccessDecisionManager(customizeAccessDecisionManager);
                return o;
            }
        });

        // 自定义过滤器在登录时认证用户名、密码
        http.addFilterAt(customizeAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
        auth.userDetailsService(customizeUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
