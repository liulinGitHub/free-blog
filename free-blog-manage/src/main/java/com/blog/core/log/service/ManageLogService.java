package com.blog.core.log.service;

import com.blog.core.log.dto.ManageLogQueryDTO;
import com.blog.core.log.entity.ManageLog;
import com.blog.core.log.vo.ManageLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import java.util.List;

/**
 * @ClassNmae: ManageLogService
 * @description:
 * @Author: liulin
 * @Date: 2019/4/14 23:54
 **/
public interface ManageLogService {

    /**
     * 查询日志
     *
     * @param manageLogQueryDTO
     * @return
     */
    List<ManageLogVO> queryLogByPage(ManageLogQueryDTO manageLogQueryDTO);

    /**
     * 保存日志
     *
     * @param joinPoint
     * @param manageLog
     * @throws JsonProcessingException
     */
    void addLog(ProceedingJoinPoint joinPoint, ManageLog manageLog) throws JsonProcessingException;
}
