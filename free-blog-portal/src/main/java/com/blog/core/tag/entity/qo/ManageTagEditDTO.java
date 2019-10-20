package com.blog.core.tag.entity.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ManageTagEditQO
 * @description:
 * @author: liulin
 * @create: 2019-07-23 17:55
 * @Version: 1.0
 */
@Data
public class ManageTagEditDTO {

    @ApiModelProperty(name = "id" )
    private String id;

    @ApiModelProperty("标签名称")
    private String tagName;

    @ApiModelProperty("标签类别名称ID")
    private String tagCategoryId;
}
