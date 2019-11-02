package com.blog.core.system.auth.security;

import com.blog.core.system.auth.impl.CustomAccessDecisionManagerImpl;
import com.blog.core.system.auth.impl.CustomFilterInvocationSecurityMetadataSource;
import com.blog.core.system.user.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNmae: SecurityConfiguration
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:57
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    @Resource(name="customAccessDecisionManager")
//    protected CustomAccessDecisionManagerImpl customAccessDecisionManager;
//
//    @Resource(name="customFilterInvocationSecurityMetadataSource")
//    protected CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.antMatcher("/**").authorizeRequests();
//
//        registry.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//            @Override
//            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
//                o.setAccessDecisionManager(customAccessDecisionManager);
//                return o;
//            }
//        });
//        registry.anyRequest().authenticated();
//        registry.and().headers().frameOptions().disable();

//        http.addFilterAfter(this.getCustomFilterSecurityInterceptor(), FilterSecurityInterceptor.class);
//
//        http.csrf().disable();
//
//        http
//                .authorizeRequests()
//                // .antMatchers("/oauth/**").permitAll()
//                .anyRequest().authenticated();
//
//        http.cors().and().csrf().disable();
//                .authorizeRequests()
//                //过滤oauth
//                .antMatchers("/oauth/**").permitAll()
//                //过滤首页
//                .antMatchers("/").permitAll()
//                // swagger
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/swagger-resources").permitAll()
//                .antMatchers("/v2/api-docs").permitAll()
//                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
//                // 其他所有请求需要身份认证
//                .anyRequest().authenticated();
        http.authorizeRequests().anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                fsi.setAccessDecisionManager(myAccessDecisionManager());
                fsi.setSecurityMetadataSource(mySecurityMetadataSource());
                return fsi;
            }
        });

    }

    /**
     * 对password授权模式的支持
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


//    @Bean("authenticationManager")
//    public AuthenticationManager getAuthenticationManager() {
//        List<AuthenticationProvider> providers = Arrays.asList(this.getAuthenticationProvider());
//        AuthenticationManager authenticationManager = new ProviderManager(providers);
//
//        return authenticationManager;
//    }

//    @Bean
//    // @Override
//    public AuthenticationManager getAuthenticationManager() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Bean
    public FilterInvocationSecurityMetadataSource mySecurityMetadataSource() {
        CustomFilterInvocationSecurityMetadataSource securityMetadataSource = new CustomFilterInvocationSecurityMetadataSource();
        return securityMetadataSource;
    }

    @Bean
    public AccessDecisionManager myAccessDecisionManager() {
        return new CustomAccessDecisionManagerImpl();
    }

//    private Filter getCustomFilterSecurityInterceptor() throws Exception {
//        FilterSecurityInterceptor filter = new FilterSecurityInterceptor();
//        filter.setAuthenticationManager(this.getAuthenticationManager());
//        filter.setAccessDecisionManager(customAccessDecisionManager);
//        filter.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
//        return filter;
//    }

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("blog");
        System.out.println(password);
    }
}
