package com.blog.core.aspect;

import com.blog.core.common.enums.ResultTypeEnum;
import com.blog.core.common.utils.HttpContextUtils;
import com.blog.core.entity.ManageLog;
import com.blog.core.service.ManageLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassNmae: ManageLogAspect
 * @description: 后台日志AOP
 * @Author: liulin
 * @Date: 2020/4/4 14:31
 **/
@Slf4j
@Aspect
@Component
public class ManageLogAspect {

    @Value("${freeBlog.isOpenManageAopLog}")
    private Boolean isOpenManageAopLog;

    @Autowired
    private ManageLogService manageLogService;

    ThreadLocal<Long> currentTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.blog.core.annotation.LogManage)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        if (isOpenManageAopLog) {
            currentTime.set(System.currentTimeMillis());
            result = joinPoint.proceed();
            ManageLog manageLog = new ManageLog();
            manageLog.setTimeConsuming(System.currentTimeMillis() - currentTime.get());
            currentTime.remove();
            manageLog.setResultType(ResultTypeEnum.SUCCESS.getValue());
            HttpServletRequest request = HttpContextUtils.getHttpServletRequest();

            manageLogService.addLog(joinPoint, request, manageLog);
        }
        return result;
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) throws Throwable {
        ManageLog manageLog = new ManageLog();
        manageLog.setTimeConsuming(System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        manageLog.setResultType(ResultTypeEnum.ERROR.getValue());
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        manageLogService.addLog((ProceedingJoinPoint)joinPoint, request, manageLog);
    }
}
