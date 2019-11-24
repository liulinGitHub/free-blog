package com.blog.core.log.dao;

import com.blog.core.log.entity.domain.ManageLog;
import com.blog.core.log.entity.dto.ManageLogQueryDTO;
import com.blog.core.log.entity.vo.ManageLogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PortalLogMapper
 * @description:
 * @author: liulin
 * @create: 2019-07-22 10:50
 * @Version: 1.0
 */
@Repository("manageLogMapper")
public interface ManageLogMapper {

    /**
     * 分页查询日志信息
     * @param portalLogQueryDTO
     * @return
     */
    List<ManageLogVO> selectLogByPage(ManageLogQueryDTO portalLogQueryDTO);

    /**
     * 添加日志信息
     * @param portalLog
     * @return
     */
    int saveLog(ManageLog portalLog);
}