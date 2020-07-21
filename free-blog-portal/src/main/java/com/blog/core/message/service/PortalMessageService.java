package com.blog.core.message.service;

import com.blog.core.message.dto.PortalMessageAddDTO;
import com.blog.core.message.dto.PortalMessageQueryDTO;
import com.blog.core.message.vo.PortalMessageVO;

import java.util.List;

/**
 * @ClassName: PortalMessageService
 * @description: 消息服务Service
 * @author: 950103
 * @create: 2019-08-09 14:32
 * @Version: 1.0
 */
public interface PortalMessageService {

    /**
     * 查询消息
     *
     * @param portalMessageQueryDTO
     * @return
     */
    List<PortalMessageVO> queryPortalMessageByPage(PortalMessageQueryDTO portalMessageQueryDTO);

    /**
     * 添加消息
     *
     * @param portalMessageAddDTO
     */
    void savePortalMessage(PortalMessageAddDTO portalMessageAddDTO);
}
