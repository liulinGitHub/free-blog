package com.blog.core.common.config;

import com.blog.core.common.interceptor.ResponseResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName: EnumConverterConfig
 * @description:
 * @Author: 950103
 * @Date: 2019/12/19 23:43
 **/
@Configuration
public class EnumConverterConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(converterFactory());
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.responseResultInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * 绑定枚举类型参数
     */
    @Bean
    public EnumConverterFactory converterFactory(){
        return new EnumConverterFactory();
    }
}
