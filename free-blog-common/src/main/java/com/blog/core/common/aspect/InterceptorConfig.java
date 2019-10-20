package com.blog.core.common.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: InterceptorConfig
 * @description: 重写WebMvcConfigurerAdapter的方法来添加自定义拦截器
 * @author: liulin
 * @create: 2019-05-16 11:28
 * @Version: 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Bean
    public AuthorityInterceptor authorityInterceptor() {
        AuthorityInterceptor authorityInterceptor = new AuthorityInterceptor();
        return authorityInterceptor;
    }
}
