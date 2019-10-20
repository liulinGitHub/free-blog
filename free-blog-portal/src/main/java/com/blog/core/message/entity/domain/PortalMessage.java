package com.blog.core.message.entity.domain;

import com.blog.core.common.enums.MessageReadEnum;
import com.blog.core.common.enums.MessageTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @program: PortalMessage
 * @description:
 * @author: liulin
 * @create: 2019-08-09 14:37
 * @Version: 1.0
 */
@Data
public class PortalMessage {

    private String id;

    /**
     * '接收人'
     */
    private String receiveId;

    /**
     * '接收时间'
     */
    private Date receiveTime;

    /**
     * '发送人id'
     */
    private String sendId;

    /**
     * '发送时间'
     */
    private Date sendTime;

    /**
     * '发送内容'
     */
    private String content;

    /**
     * 类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息
     */
    private MessageTypeEnum messageType;

    /**
     * 1 已读 0 未读
     */
    private MessageReadEnum readStatus;
}
