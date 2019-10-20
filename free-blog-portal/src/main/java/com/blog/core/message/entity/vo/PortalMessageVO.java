package com.blog.core.message.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @program: PortalMessageVO
 * @description: 消息vo
 * @author: liulin
 * @create: 2019-08-09 14:36
 * @Version: 1.0
 */
@Data
public class PortalMessageVO {

    private String messageId;

    /**
     * 接收人
     */
    private String receiveId;

    /**
     * 接收人名称
     */
    private String receiveName;

    /**
     * 接收人头像
     */
    private String receiveImage;

    /**
     * 接收时间
     */
    private Date receiveTime;

    /**
     * 发送人id
     */
    private String sendId;

    /**
     * 发送人名称
     */
    private String sendName;

    /**
     * 发送人头像
     */
    private String sendImage;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 发送内容
     */
    private String content;

    /**
     * 类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息
     */
    private String messageType;

    /**
     * 类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息
     */
    private String messageTypeName;

    /**
     * 1 已读 0 未读
     */
    private String readStatus;

    /**
     * 类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息
     */
    private String readStatusName;

}
