package com.blog.core.service;

import com.blog.core.dto.ServerLogQueryDTO;
import com.blog.core.entity.ServerLog;
import com.blog.core.vo.ServerLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae: SysBaseLogService
 * @description:
 * @Author: 950103
 * @Date: 2019/4/14 23:54
 **/
public interface ServerLogService {

    /**
     * 分页查询前端系统操作日志
     *
     * @param  serverLogQueryDTO
     * @return List<PortalLogVO>
     **/
    List<ServerLogVO> queryServerLogByPage(ServerLogQueryDTO serverLogQueryDTO);


    /**
     * 保存日志
     *
     * @param joinPoint
     * @param serverLog
     * @throws JsonProcessingException
     */
    void addServerLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, ServerLog serverLog) throws JsonProcessingException;
}
