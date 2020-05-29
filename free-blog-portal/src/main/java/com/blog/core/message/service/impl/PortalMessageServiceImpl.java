package com.blog.core.message.service.impl;

import com.blog.core.common.enums.MessageReadEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.message.dao.PortalMessageMapper;
import com.blog.core.message.entity.domain.PortalMessage;
import com.blog.core.message.entity.dto.PortalMessageAddDTO;
import com.blog.core.message.entity.dto.PortalMessageQueryDTO;
import com.blog.core.message.entity.vo.PortalMessageVO;
import com.blog.core.message.service.PortalMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @program: PortalMessageServiceImpl
 * @description:
 * @author: liulin
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
        List<PortalMessageVO> portalMessageVOList = this.portalMessageMapper.selectPortalMessageByPage(portalMessageQueryDTO);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                List<PortalMessageVO> portalMessageVOList = portalMessageMapper.selectPortalMessageByPage(portalMessageQueryDTO);
            }
        });
        return portalMessageVOList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addPortalMessage(PortalMessageAddDTO portalMessageAddDTO) {
        PortalMessage portalMessage = MapperUtils.mapperBean(portalMessageAddDTO, PortalMessage.class);
        portalMessage.setId(UUIDUtil.randomUUID32());
        portalMessage.setReadStatus(MessageReadEnum.MESSAGE_READ_NO);
        this.portalMessageMapper.insertPortalMessage(portalMessage);
    }
}
