package com.blog.core.message.service.impl;

import com.blog.core.common.enums.MessageReadEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.message.dao.PortalMessageMapper;
import com.blog.core.message.dto.PortalMessageAddDTO;
import com.blog.core.message.dto.PortalMessageQueryDTO;
import com.blog.core.message.entity.PortalMessage;
import com.blog.core.message.service.PortalMessageService;
import com.blog.core.message.vo.PortalMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: PortalMessageServiceImpl
 * @description: 消息服务Service
 * @author: 950103
 * @create: 2019-08-09 14:32
 * @Version: 1.0
 */
@Service("portalMessageService")
public class PortalMessageServiceImpl implements PortalMessageService {

    @Autowired
    private PortalMessageMapper portalMessageMapper;

    @Transactional
    @Override
    public List<PortalMessageVO> queryPortalMessageByPage(PortalMessageQueryDTO portalMessageQueryDTO) {
        return this.portalMessageMapper.selectPortalMessageByPage(portalMessageQueryDTO);
    }

    @Transactional
    @Override
    public void savePortalMessage(PortalMessageAddDTO portalMessageAddDTO) {
        PortalMessage portalMessage = MapperUtils.mapperBean(portalMessageAddDTO, PortalMessage.class);
        portalMessage.setMessageId(UUIDUtil.randomUUID32());
        portalMessage.setReadStatus(MessageReadEnum.MESSAGE_READ_NO);
        this.portalMessageMapper.insertPortalMessage(portalMessage);
    }
}
