package com.blog.core.tag.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalTagQueryDTO
 * @description: 标签查询
 * @author: 950103
 * @create: 2019-07-23 17:55
 * @Version: 1.0
 */
@Data
public class PortalTagQueryDTO {

    @ApiModelProperty("标签名称")
    private String tagName;
}
