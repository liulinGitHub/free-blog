package com.blog.core.dao;

import com.blog.core.dto.ServerLogQueryDTO;
import com.blog.core.entity.ServerLog;
import com.blog.core.vo.ServerLogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: ServerLogMapper
 * @description:
 * @author: 950103
 * @create: 2019-07-22 10:50
 * @Version: 1.0
 */
@Repository("serverLogMapper")
public interface ServerLogMapper {

    List<ServerLogVO> selectPortalLogByPage(ServerLogQueryDTO serverLogQueryDTO);

    /**
     * 添加日志信息
     *
     * @param serverLog
     * @return
     */
    int insertServerLog(ServerLog serverLog);
}
