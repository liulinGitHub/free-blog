package com.blog.core.message.dto;

import com.blog.core.common.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: PortalMessageAddDTO
 * @description: 消息添加参数
 * @author: 950103
 * @create: 2019-08-09 15:26
 * @Version: 1.0
 */
@Data
public class PortalMessageAddDTO {

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
}
