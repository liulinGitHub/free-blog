//package com.blog.core.common.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @program: CorsConfig
// * @description: 解决跨域
// * @author: liulin
// * @create: 2019-07-13 11:44
// * @Version: 1.0
// */
//@Configuration
//@EnableWebMvc
//public class ConfigurerAdapter implements WebMvcConfigurer {
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        /*允许访问的客户端域名*/
//        config.addAllowedOrigin("*");
//        /*允许服务端访问的客户端请求头*/
//        config.addAllowedHeader("*");
//        /*允许访问的方法名,GET POST等*/
//        config.addAllowedMethod("*");
//        /*是否允许请求带有验证信息*/
//        config.setAllowCredentials(true);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
