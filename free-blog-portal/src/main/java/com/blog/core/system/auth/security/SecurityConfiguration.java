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
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/", "/index").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/user").permitAll().and().logout().permitAll()

                .and().authorizeRequests().anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O fsi) {
                        fsi.setAccessDecisionManager(accessDecisionManager());
                        fsi.setSecurityMetadataSource(securityMetadataSource());
                        return fsi;
                    }
                });
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        return new CustomAccessDecisionManagerImpl();
    }

    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
        return new CustomFilterInvocationSecurityMetadataSource();
    }
}
