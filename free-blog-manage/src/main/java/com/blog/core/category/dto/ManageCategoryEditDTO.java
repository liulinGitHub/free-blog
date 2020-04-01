package com.blog.core.category.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ArticleCategoryEditDTO
 * @description: 文章分类修改传参对象
 * @author: liulin
 * @create: 2019-05-07 11:30
 * @Version: 1.0
 */
@Data
public class ManageCategoryEditDTO {

    @ApiModelProperty(name = "类别ID" )
    private String categoryId;

    @ApiModelProperty(name = "类别名称" )
    private String categoryName;

    @ApiModelProperty(name = "排序" )
    private Integer sort;

    @ApiModelProperty("类别父名称id" )
    private String parentCategoryId;
}
