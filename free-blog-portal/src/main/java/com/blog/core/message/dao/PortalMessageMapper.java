package com.blog.core.message.dao;

import com.blog.core.message.entity.domain.PortalMessage;
import com.blog.core.message.entity.dto.PortalMessageQueryDTO;
import com.blog.core.message.entity.vo.PortalMessageVO;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @program: PortalMessageMapper
 * @description:
 * @author: liulin
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
