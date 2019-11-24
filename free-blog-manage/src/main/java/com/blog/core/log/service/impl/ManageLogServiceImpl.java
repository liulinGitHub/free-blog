package com.blog.core.log.service.impl;

import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.log.dao.ManageLogMapper;
import com.blog.core.log.entity.domain.ManageLog;
import com.blog.core.log.entity.dto.ManageLogQueryDTO;
import com.blog.core.log.entity.vo.ManageLogVO;
import com.blog.core.log.service.ManageLogService;
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

@Service("manageLogService")
public class ManageLogServiceImpl implements ManageLogService {

    @Autowired
    private ManageLogMapper manageLogMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ManageLogVO> queryLogByPage(ManageLogQueryDTO manageLogQueryDTO){
        List<ManageLogVO> portalLogList = this.manageLogMapper.selectLogByPage(manageLogQueryDTO);
        return portalLogList;
    }

    @Override
    public void addLog(ProceedingJoinPoint joinPoint, ManageLog manageLog) throws JsonProcessingException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogPortal logAnnotation = method.getAnnotation(LogPortal.class);
        if (logAnnotation != null) {
            // 注解上的描述
            manageLog.setOperation(logAnnotation.value());
        }
        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        manageLog.setMethodName(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            manageLog.setRequestParams(params.toString());
        }
        manageLog.setOperatingTime(new Date());
        manageLog.setId(UUIDUtil.randomUUID32());
        // 保存系统日志
        try {
            this.manageLogMapper.saveLog(manageLog);
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
