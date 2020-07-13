package com.blog.core.category.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalCategory
 * @description: 文章分类信息
 * @author: 950103
 * @create: 2019-05-04 16:28
 */
@Data
public class PortalCategory extends BaseModel {

    @ApiModelProperty(name = "类别名称" )
    private String categoryName;

    @ApiModelProperty(name = "类别父名称id" )
    private String parentCategoryId;

    @ApiModelProperty(name = "排序" )
    private Integer sort;

    @ApiModelProperty(name = "删除标识" )
    private String isEnable;
}
