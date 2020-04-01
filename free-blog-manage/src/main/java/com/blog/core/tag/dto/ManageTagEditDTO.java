package com.blog.core.tag.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ManageTagEditDTO
 * @description: 标签修改参数
 * @author: liulin
 * @create: 2020-01-18 14:05
 * @Version: 1.0
 */
@Data
public class ManageTagEditDTO {

    @ApiModelProperty("标签id")
    private String tagId;

    @ApiModelProperty("标签名称")
    private String tagName;
}
