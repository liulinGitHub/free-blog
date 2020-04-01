package com.blog.core.tag.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ManageTagAddDTO
 * @description: 标签添加参数
 * @author: liulin
 * @create: 2020-01-18 14:05
 * @Version: 1.0
 */
@Data
public class ManageTagAddDTO {

    @ApiModelProperty("标签id")
    private String tagId;

    @ApiModelProperty("标签名称")
    private String tagName;
}
