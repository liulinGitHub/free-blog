package com.blog.core.system.auth.exception;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.common.utils.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: AuthExceptionEntryPoint
 * @description: 自定义token校验
 * @author: liulin
 * @create: 2020-04-11 15:37
 * @Version: 1.0
 */
@Slf4j
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write(JSONObject.toJSONString(ResponseBo.tokenError("token异常，禁止访问！")));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
