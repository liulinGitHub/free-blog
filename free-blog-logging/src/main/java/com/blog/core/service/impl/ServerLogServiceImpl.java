package com.blog.core.service.impl;

import com.blog.core.annotation.LogServer;
import com.blog.core.common.utils.IPUtils;
import com.blog.core.common.utils.PrimarykeyUtil;
import com.blog.core.dao.ServerLogMapper;
import com.blog.core.dto.ServerLogQueryDTO;
import com.blog.core.entity.ServerLog;
import com.blog.core.service.ServerLogService;
import com.blog.core.vo.ServerLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

@Slf4j
@Service("serverLogService")
public class ServerLogServiceImpl implements ServerLogService {

    @Autowired
    private ServerLogMapper serverLogMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Override
    public List<ServerLogVO> queryServerLogByPage(ServerLogQueryDTO serverLogQueryDTO) {
        return this.serverLogMapper.selectPortalLogByPage(serverLogQueryDTO);
    }

    @Async
    @Override
    public void addServerLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, ServerLog serverLog) throws JsonProcessingException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogServer logAnnotation = method.getAnnotation(LogServer.class);
        if (logAnnotation != null) {
            // 注解上的描述
            serverLog.setDescription(logAnnotation.value());
        }
        // 请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = signature.getName();
        serverLog.setMethodName(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            serverLog.setRequestParams(params.toString());
        }
        serverLog.setOperatingTime(new Date());
        serverLog.setLogId(primarykeyUtil.getPimaryKey());
        serverLog.setIpAddress(IPUtils.getIpAddr(request));
        serverLog.setAddress(IPUtils.getCityInfo(IPUtils.getIpAddr(request)));
        serverLog.setBrowser(IPUtils.getBrowser(request));
        serverLog.setRequestPath(request.getRequestURI());
        serverLog.setRequestMethod(request.getMethod());
//        SecurityUser user = SecurityUtils.getUser();
//        if (Objects.nonNull(user)) {
//            manageLog.setOperatingId(user.getUserId());
//        }
        try {
            this.serverLogMapper.insertServerLog(serverLog);
        }catch (Exception e){
            log.error("保存系统日志失败:", e.getMessage());
        }
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
