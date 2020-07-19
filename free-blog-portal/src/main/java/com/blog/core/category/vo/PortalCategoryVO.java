package com.blog.core.category.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalCategoryVO
 * @description: 文章分类信息返回前端对象
 * @author: 950103
 * @create: 2019-05-04 16:31
 */
@Data
public class PortalCategoryVO {

    @ApiModelProperty(name = "分类id" )
    private String categoryId;

    @ApiModelProperty(name = "类别名称" )
    private String categoryName;
}
