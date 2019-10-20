package com.blog.core.log.service;

import com.blog.core.log.entity.domain.PortalLog;
import com.blog.core.log.entity.dto.PortalLogQueryDTO;
import com.blog.core.log.entity.vo.PortalLogVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.ProceedingJoinPoint;
import java.util.List;

/**
 * @ClassNmae: SysBaseLogService
 * @description:
 * @Author: liulin
 * @Date: 2019/4/14 23:54
 **/
public interface PortalLogService {

    /**
     * 查询日志
     * @param portalLogQueryDTO
     * @return
     */
    List<PortalLogVO> queryLogByPage(PortalLogQueryDTO portalLogQueryDTO);

    /**
     * 保存日志
     * @param joinPoint
     * @param portalLog
     * @throws JsonProcessingException
     */
    void addLog(ProceedingJoinPoint joinPoint, PortalLog portalLog) throws JsonProcessingException;
}
