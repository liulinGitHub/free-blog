package com.blog.core.system.auth.filter;//package com.blog.core.system.auth.filter;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @ClassNmae: CustomizeAuthenticationProcessingFilter
// * @description: 自定义过滤器在登录时认证用户名、密码
// * @Author: 950103
// * @Date: 2020/2/22 20:29
// **/
//@Component
//public class CustomizeAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
//
//    public CustomizeAuthenticationProcessingFilter(){
//        super(new AntPathRequestMatcher("/login", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        return null;
//    }
//}
