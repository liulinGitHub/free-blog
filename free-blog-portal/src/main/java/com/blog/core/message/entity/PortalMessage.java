package com.blog.core.message.entity;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.enums.MessageReadEnum;
import com.blog.core.common.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PortalMessage
 * @description:
 * @author: 950103
 * @create: 2019-08-09 14:37
 * @Version: 1.0
 */
@Data
public class PortalMessage {

    @ApiModelProperty("消息ID")
    private String messageId;

    @ApiModelProperty("接收人")
    private String receiveId;

    @ApiModelProperty("接收时间")
    private Date receiveTime;

    @ApiModelProperty("发送人id")
    private String sendId;

    @ApiModelProperty("发送时间")
    private Date sendTime;

    @ApiModelProperty("发送内容")
    private String content;

    @ApiModelProperty("类型 1：回复 2：@ 3：赞 4：系统 5：私信 6：我的消息")
    private MessageTypeEnum messageType;

    @ApiModelProperty("1 已读 0 未读")
    private MessageReadEnum readStatus;

    @ApiModelProperty("启用/停用 1 启用 0 停用")
    private EnableEnum enable;
}
