package com.blog.core.common.exceptions;

import com.blog.core.common.enums.ExceptionEnum;
import com.blog.core.common.utils.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.security.access.AccessDeniedException;

/**
 * @description: 自定义全局异常
 * @author: 950103
 * @create_time: 2019-04-22 17:24
 * @version: 1.0
 */
@Slf4j
@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseBo handleException(Exception e) {
        log.error("internal server error 500", e);
        return ResponseBo.error(e.getMessage());
    }

    /**
     * TOKEN异常
     * @param e
     * @return
     */
    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public ResponseBo tokenException(TokenException e) {
        return ResponseBo.tokenError(ExceptionEnum.TOKEN_NONE.getName());
    }


    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BlogRuntimeException.class)
    @ResponseBody
    public ResponseBo blogRuntimeException(BlogRuntimeException e) {
        return ResponseBo.error(e.getMessage());
    }

    /**
     * 授权异常
     * @param e
     * @return
     */
    @ExceptionHandler(BlogAuth2Exception.class)
    @ResponseBody
    public ResponseBo accessDeniedException(BlogAuth2Exception e) {
        log.error("授权异常", e);
        return ResponseBo.error(e.getMessage());
    }

    @ExceptionHandler(CaptchaException.class)
    @ResponseBody
    public ResponseBo accessDeniedException(CaptchaException e) {
        log.error("验证码异常", e);
        return ResponseBo.error(e.getMessage());
    }
}
