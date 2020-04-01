package com.blog.core.category.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.CategoryBelongTypeEnum;
import com.blog.core.common.enums.IsEnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: free-blog
 * @description: 文章分类信息
 * @author: liulin
 * @create: 2019-05-04 16:28
 */
@Data
public class ManageCategory extends BaseModel {

    @ApiModelProperty("类别ID" )
    private String categoryId;

    @ApiModelProperty("类别名称" )
    private String categoryName;

    @ApiModelProperty("类别父名称id" )
    private String parentCategoryId;

    @ApiModelProperty("分类所属")
    private CategoryBelongTypeEnum categoryBelongType;

    @ApiModelProperty("分类所属id")
    private String categoryBelongId;
    
    @ApiModelProperty("排序" )
    private Integer sort;

    @ApiModelProperty("删除标识" )
    private IsEnableEnum isEnable;
}
