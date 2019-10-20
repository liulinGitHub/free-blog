package com.blog.core.articlecategory.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: free-blog
 * @description: 文章分类信息
 * @author: liulin
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
