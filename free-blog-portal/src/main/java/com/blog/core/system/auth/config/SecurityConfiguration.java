package com.blog.core.system.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassNmae: SecurityConfiguration
 * @description:
 * @Author: liulin
 * @Date: 2020/2/14 13:50
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        Set<String> anonymousUrls = new HashSet<>();
//
//        http
//            // 禁用 CSRF
//            .csrf().disable()
//            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//            .exceptionHandling()
//
//            .and()
//            .authorizeRequests()
//            // 静态资源等等
//            .antMatchers(
//                    HttpMethod.GET,
//                    "/*.html",
//                    "/**/*.html",
//                    "/**/*.css",
//                    "/**/*.js",
//                    "/webSocket/**"
//            ).permitAll()
//            // swagger 文档
//            .antMatchers("/swagger-ui.html").permitAll()
//            .antMatchers("/swagger-resources/**").permitAll()
//            .antMatchers("/webjars/**").permitAll()
//            .antMatchers("/*/api-docs").permitAll()
//            // 文件
//            .antMatchers("/avatar/**").permitAll()
//            .antMatchers("/file/**").permitAll()
//            // 阿里巴巴 druid
//            .antMatchers("/druid/**").permitAll()
//            // 放行OPTIONS请求
//            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//            // 自定义匿名访问所有url放行 ： 允许匿名和带权限以及登录用户访问
//            .antMatchers(anonymousUrls.toArray(new String[0])).permitAll()
//            // 所有请求都需要认证
//            .anyRequest().authenticated();
//            // .and().apply(securityConfigurerAdapter());

        http
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            .and().csrf().disable();
    }

    /**
     * 配置认证管理器
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults() {
        // 去除 ROLE_ 前缀
        return new GrantedAuthorityDefaults("");
    }


//    @Bean
//    public MobileCodeAuthenticationProvider provider() {
//        MobileCodeAuthenticationProvider provider = new MobileCodeAuthenticationProvider();
//        provider.setStringRedisTemplate(stringRedisTemplate);
//        provider.setHideUserNotFoundExceptions(false);
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }
}
