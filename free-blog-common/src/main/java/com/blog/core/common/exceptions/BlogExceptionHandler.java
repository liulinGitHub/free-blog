package com.blog.core.common.exceptions;

import com.blog.core.common.enums.ExceptionEnum;
import com.blog.core.common.utils.ResponseBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @program: free_blog
 * @description: 自定义全局异常
 * @author: liulin
 * @create: 2019-04-22 17:24
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
        return ResponseBo.tokenError(ExceptionEnum.TOKEN_NONE.getMessage());
    }

    /**
     * 数据未找到
     * @param e
     * @return
     */
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    public ResponseBo DataNotFoundException(DataNotFoundException e) {
        return ResponseBo.error(ExceptionEnum.DATA_NOT_FOUND.getMessage());
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

}
