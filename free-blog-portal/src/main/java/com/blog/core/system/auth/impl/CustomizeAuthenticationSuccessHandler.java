package com.blog.core.system.auth.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.entity.domain.SecurityUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: CustomizeAuthenticationSuccessHandler
 * @description: 自定义登录成功处理器
 * @author: liulin
 * @create: 2019-12-24 18:31
 * @Version: 1.0
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails)authentication.getPrincipal();
        System.out.println(securityUserDetails);
        String responseBoJsonString = JSONObject.toJSONString(ResponseBo.newDataResponse(securityUserDetails.getPortalUserLoginVO()));
        response.getWriter().write(responseBoJsonString);
    }
}
