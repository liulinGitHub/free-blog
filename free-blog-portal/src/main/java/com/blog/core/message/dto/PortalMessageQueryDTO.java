package com.blog.core.message.dto;

import com.blog.core.common.enums.MessageTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalMessageQueryDto
 * @description: 消息查询参数
 * @author: 950103
 * @create: 2019-08-09 14:43
 * @Version: 1.0
 */
@Data
public class PortalMessageQueryDTO {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("消息类型")
    private MessageTypeEnum messageType;
}
