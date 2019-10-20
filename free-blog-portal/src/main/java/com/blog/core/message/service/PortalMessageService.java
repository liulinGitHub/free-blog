package com.blog.core.message.service;


import com.blog.core.message.entity.dto.PortalMessageAddDTO;
import com.blog.core.message.entity.dto.PortalMessageQueryDTO;
import com.blog.core.message.entity.vo.PortalMessageVO;

import java.util.List;
/**
 * @program: PortalMessageService
 * @description: 消息服务Service
 * @author: liulin
 * @create: 2019-08-09 14:32
 * @Version: 1.0
 */
public interface PortalMessageService {

    /**
     * 查询消息
     * @param portalMessageQueryDTO
     * @return
     */
    List<PortalMessageVO> queryPortalMessageByPage(PortalMessageQueryDTO portalMessageQueryDTO);

    /**
     * 添加消息
     * @param portalMessageAddDTO
     */
    void addPortalMessage(PortalMessageAddDTO portalMessageAddDTO);
}
