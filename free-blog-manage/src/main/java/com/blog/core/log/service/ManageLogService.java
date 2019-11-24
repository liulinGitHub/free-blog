package com.blog.core.log.service;

import com.blog.core.log.entity.domain.ManageLog;
import com.blog.core.log.entity.dto.ManageLogQueryDTO;
import com.blog.core.log.entity.vo.ManageLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;

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
     * @param portalLogQueryDTO
     * @return
     */
    List<ManageLogVO> queryLogByPage(ManageLogQueryDTO manageLogQueryDTO);

    /**
     * 保存日志
     * @param joinPoint
     * @param manageLog
     * @throws JsonProcessingException
     */
    void addLog(ProceedingJoinPoint joinPoint, ManageLog manageLog) throws JsonProcessingException;
}
