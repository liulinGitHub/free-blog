package com.blog.core.message.dao;

import com.blog.core.message.dto.PortalMessageQueryDTO;
import com.blog.core.message.entity.PortalMessage;
import com.blog.core.message.vo.PortalMessageVO;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName: PortalMessageMapper
 * @description: 消息服务Mapper
 * @author: 950103
 * @create: 2019-08-09 14:33
 * @Version: 1.0
 */
@Repository("portalMessageMapper")
public interface PortalMessageMapper {

    /**
     * 分页查看消息
     * @param portalMessageQueryDTO
     * @return
     */
    List<PortalMessageVO> selectPortalMessageByPage(PortalMessageQueryDTO portalMessageQueryDTO);

    /**
     * 新增消息
     * @param portalMessage
     */
    void insertPortalMessage(PortalMessage portalMessage);
}
