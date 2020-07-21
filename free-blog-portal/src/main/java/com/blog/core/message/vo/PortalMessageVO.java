package com.blog.core.message.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PortalMessageVO
 * @description: 消息vo
 * @author: 950103
 * @create: 2019-08-09 14:36
 * @Version: 1.0
 */
@Data
public class PortalMessageVO {

    @ApiModelProperty("消息ID")
    private String messageId;

    @ApiModelProperty("接收人")
    private String receiveId;

    @ApiModelProperty("接收时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date receiveTime;

    @ApiModelProperty("发送人id")
    private String sendId;

    @ApiModelProperty("发送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;

    @ApiModelProperty("发送内容")
    private String content;

    @ApiModelProperty("消息类型 0：回复 2：@ 4：赞 6：系统 8：私信 10：我的消息")
    private String messageType;

    @ApiModelProperty("1 已读 0 未读")
    private String readStatus;

}
