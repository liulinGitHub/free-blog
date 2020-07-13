package com.blog.core.log.service.impl;

import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.*;
import com.blog.core.log.dao.PortalLogMapper;
import com.blog.core.log.entity.domain.PortalLog;
import com.blog.core.log.entity.dto.PortalLogQueryDTO;
import com.blog.core.log.vo.PortalLogVO;
import com.blog.core.log.service.PortalLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

@Service("portalLogService")
public class PortalLogServiceImpl implements PortalLogService {

    @Autowired
    private PortalLogMapper portalLogMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<PortalLogVO> queryLogByPage(PortalLogQueryDTO portalLogQueryDTO){
        List<PortalLogVO> portalLogList = this.portalLogMapper.selectLogByPage(portalLogQueryDTO);
        return portalLogList;
    }

    @Override
    public void addLog(ProceedingJoinPoint joinPoint, PortalLog portalLog) throws JsonProcessingException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogPortal logAnnotation = method.getAnnotation(LogPortal.class);
        if (logAnnotation != null) {
            // 注解上的描述
            portalLog.setOperation(logAnnotation.value());
        }
        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        portalLog.setMethodName(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            portalLog.setRequestParams(params.toString());
        }
        portalLog.setOperatingTime(new Date());
        portalLog.setId(UUIDUtil.randomUUID32());
        // 保存系统日志
        try {
            this.portalLogMapper.saveLog(portalLog);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        System.out.println(12);
    }

    @SuppressWarnings("unchecked")
    private StringBuilder handleParams(StringBuilder params, Object[] args, List paramNames) throws JsonProcessingException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set set = ((Map) args[i]).keySet();
                List list = new ArrayList();
                List paramList = new ArrayList<>();
                for (Object key : set) {
                    list.add(((Map) args[i]).get(key));
                    paramList.add(key);
                }
                return handleParams(params, list.toArray(), paramList);
            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> aClass = args[i].getClass();
                    try {
                        aClass.getDeclaredMethod("toString", new Class[]{null});
                        // 如果不抛出NoSuchMethodException 异常则存在 toString 方法 ，安全的writeValueAsString ，否则 走 Object的 toString方法
                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                    }
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append("  ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append("  ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return params;
    }
}
