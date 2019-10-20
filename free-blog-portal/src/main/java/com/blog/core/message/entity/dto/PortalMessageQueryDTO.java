package com.blog.core.message.entity.dto;

import com.blog.core.common.enums.MessageTypeEnum;
import lombok.Data;

/**
 * @program: PortalMessageQueryDto
 * @description:
 * @author: liulin
 * @create: 2019-08-09 14:43
 * @Version: 1.0
 */
@Data
public class PortalMessageQueryDTO {

    private MessageTypeEnum messageType;
}
