package com.blog.core.system.auth.config;

import com.blog.core.system.auth.service.CustomizeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
 * @author: 950103
 * @create_time: 2020/2/14 13:50
 * @version: 1.0
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomizeUserDetailsService customizeUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customizeUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CaptchaFilter captchaFilter = new CaptchaFilter();

        http.authorizeRequests()
            .antMatchers(
                    "/oauth/**",
                    "/mobile/**").permitAll()
            .anyRequest().authenticated()
            .and().cors()
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

        public static void main(String[] args) {
        // $2a$10$RJxDZ4bZaelml3Kfzjnv9ep110tbKE4BD5Zmi5kSUj5Vn1fwvHTGq
        BCryptPasswordEncoder delegatingPasswordEncoder = new BCryptPasswordEncoder();
        String encode = delegatingPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
