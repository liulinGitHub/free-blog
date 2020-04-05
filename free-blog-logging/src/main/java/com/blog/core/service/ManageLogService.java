package com.blog.core.service;

import com.blog.core.dto.ManageLogQueryDTO;
import com.blog.core.entity.ManageLog;
import com.blog.core.vo.ManageLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassNmae: SysBaseLogService
 * @description:
 * @Author: liulin
 * @Date: 2019/4/14 23:54
 **/
public interface ManageLogService {

    /**
     * 查询日志
     * @param manageLogQueryDTO
     * @return
     */
    List<ManageLogVO> queryLogByPage(ManageLogQueryDTO manageLogQueryDTO);

    /**
     * 保存日志
     * @param joinPoint
     * @param manageLog
     * @throws JsonProcessingException
     */
    void addLog(ProceedingJoinPoint joinPoint, HttpServletRequest request, ManageLog manageLog) throws JsonProcessingException;
}
