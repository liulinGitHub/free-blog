package com.blog.core.system.auth.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;

/**
 * @program: MultiReadHttpServletRequest
 * @description:
 * @author: liulin
 * @create: 2019-12-24 18:16
 * @Version: 1.0
 */
@Slf4j
public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

    public MultiReadHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    /**
     * 将前端传递的json数据转换成json字符串 - 前后端分离的情况下使用
     * @param request:
     * @return: java.lang.String
     */
    public String getBodyJsonStrByJson(ServletRequest request){
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                json.append(line);
            }
        }
        catch(Exception e) {
            log.error("请求参数转换错误!",e);
        }
        return json.toString();
    }
}
