package com.blog.core.common.aspect;

import com.blog.core.common.annotation.CheckLogin;
import com.blog.core.common.exceptions.TokenException;
import com.blog.core.common.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: free-blog
 * @description: 自定义全局拦截器
 * @author: liulin
 * @create: 2019-04-29 13:40
 */
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 请求处理前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CheckLogin checkLogin = handlerMethod.getMethodAnnotation(CheckLogin.class);
        if(null == checkLogin){
            return true;
        }
        //从请求头中获取token
        String headerToken = request.getHeader("token");
        if (StringUtils.isNotEmpty(headerToken)) {
            //从redis中获取token
            String tokenValue = (String) redisUtil.get(headerToken);
            if (StringUtils.isEmpty(tokenValue)) {
                throw new TokenException();
            } else {
                RequestHolder.add(tokenValue);
            }
        }else {
            throw new TokenException();
        }
        return true;
    }

    /**
     * 请求后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        removeThreadLocalInfo();
    }

    public void removeThreadLocalInfo() {
        RequestHolder.remove();
    }
}
