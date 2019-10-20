package com.blog.core.message.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: PortalMessageAddDTO
 * @description:
 * @author: liulin
 * @create: 2019-08-09 15:26
 * @Version: 1.0
 */
@Data
public class PortalMessageAddDTO {

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
    private String messageType;

    /**
     * 1 已读 0 未读
     */
    private String read_status;
}
