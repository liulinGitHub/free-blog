package com.blog.core.category.dto;

import com.blog.core.common.enums.CategoryTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: free-blog
 * @description: 文章分类新增传参
 * @author: 950103
 * @create: 2019-05-06 09:45
 */

@Data
public class ManageCategoryAddDTO {

    @ApiModelProperty(name = "类别名称" )
    private String categoryName;

    @ApiModelProperty(name = "排序" )
    private Integer sort;

    @ApiModelProperty(name = "类别父名称id" )
    private String parentCategoryId;

    @ApiModelProperty("分类所属")
    private CategoryTypeEnum categoryType;

    @ApiModelProperty("分类所属id")
    private String categoryBelongId;
}
