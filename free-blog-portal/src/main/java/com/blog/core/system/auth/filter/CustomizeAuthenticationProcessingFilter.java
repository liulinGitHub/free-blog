package com.blog.core.system.auth.filter;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.system.auth.impl.CusAuthenticationManager;
import com.blog.core.system.auth.impl.CustomizeAuthenticationSuccessHandler;
import com.blog.core.system.auth.impl.MultiReadHttpServletRequest;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: CustomizeAuthenticationProcessingFilter
 * @description: 自定义身份过滤器
 * @author: liulin
 * @create: 2019-12-24 13:49
 * @Version: 1.0
 */
@Component
public class CustomizeAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public CustomizeAuthenticationProcessingFilter(CusAuthenticationManager authenticationManager,
                                                   CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler) {
        super(new AntPathRequestMatcher("/login", "POST"));
        this.setAuthenticationManager(authenticationManager);
        this.setAuthenticationSuccessHandler(customizeAuthenticationSuccessHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        UsernamePasswordAuthenticationToken authRequest = null;
        try {
            MultiReadHttpServletRequest wrappedRequest = new MultiReadHttpServletRequest(request);
            PortalUserLoginVO portalUserLoginVO = JSONObject.parseObject(wrappedRequest.getBodyJsonStrByJson(wrappedRequest), PortalUserLoginVO.class);
            authRequest = new UsernamePasswordAuthenticationToken(portalUserLoginVO.getUserName(), portalUserLoginVO.getUserPassword(), null);
            authRequest.setDetails(authenticationDetailsSource.buildDetails(wrappedRequest));
        }catch (Exception e){
            new AuthenticationServiceException(e.getMessage());
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
