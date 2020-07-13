package com.blog.core.log.dao;

import com.blog.core.log.entity.domain.PortalLog;
import com.blog.core.log.entity.dto.PortalLogQueryDTO;
import com.blog.core.log.vo.PortalLogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PortalLogMapper
 * @description:
 * @author: liulin
 * @create: 2019-07-22 10:50
 * @Version: 1.0
 */
@Repository("portalLogMapper")
public interface PortalLogMapper {

    /**
     * 分页查询日志信息
     * @param portalLogQueryDTO
     * @return
     */
    List<PortalLogVO> selectLogByPage(PortalLogQueryDTO portalLogQueryDTO);

    /**
     * 添加日志信息
     * @param portalLog
     * @return
     */
    int saveLog(PortalLog portalLog);
}
