package com.blog.core.log.utils;

import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.ResultTypeEnum;
import com.blog.core.common.utils.HttpContextUtils;
import com.blog.core.common.utils.IPUtils;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.log.entity.domain.ManageLog;
import com.blog.core.log.service.ManageLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: PortalLogAspect
 * @description: 日志AOP
 * @author: liulin
 * @create: 2019-07-22 10:57
 * @Version: 1.0
 */
@Slf4j
@Aspect
@Component
public class PortalLogAspect {

    @Value("${isOpenPortalAopLog}")
    private Boolean isOpenPortalAopLog;

    @Resource
    private ManageLogService manageLogService;

    @Pointcut("@annotation(com.blog.core.common.annotation.LogPortal)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        Integer code = 0;
        String resultOperation = null;
        long beginTime = System.currentTimeMillis();
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        // 设置IP地址
        String ip = IPUtils.getIpAddr(request);
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 执行方法
        try {
            result = point.proceed();
            ResponseBo responseBo = (ResponseBo) result;
            code = (Integer)responseBo.get("code");
            resultOperation = (String)responseBo.get("message");
        }catch (Exception e){
            e.getMessage();
            code = 500;
            resultOperation = e.getMessage();
        }
        if (isOpenPortalAopLog) {
            // 保存日志
            ManageLog manageLog = new ManageLog();
            System.out.println(RequestHolder.get());
            if(null != RequestHolder.get()){
                manageLog.setOperatingId(RequestHolder.get().toString());
            }
            manageLog.setIpAddress(ip);
            manageLog.setTimeConsuming(time);
            if(code == 200){
                manageLog.setResultType(ResultTypeEnum.SUCCESS.getName());
            }else {
                manageLog.setResultType(ResultTypeEnum.ERROR.getName());
            }
            manageLog.setRequestPath(requestURI);
            manageLog.setRequestMethod(method);
            manageLog.setResultOperation(resultOperation);
            this.manageLogService.addLog(point, manageLog);
        }
        return result;
    }
}
