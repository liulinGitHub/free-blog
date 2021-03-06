package com.blog.core.category.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: free-blog
 * @description: 文章分类信息返回前端对象
 * @author: 950103
 * @create: 2019-05-04 16:31
 */
@Data
public class ManageCategoryVO {

    @ApiModelProperty(name = "分类id" )
    private Integer categoryId;

    @ApiModelProperty(name = "类别名称" )
    private String categoryName;

    @ApiModelProperty(name = "类别父名称id" )
    private Integer parentCategoryId;

    @ApiModelProperty(name = "排序" )
    private Integer sort;

    @ApiModelProperty(name = "删除标识" )
    private String isEnable;

    @ApiModelProperty("创建人")
    private Integer createId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
}
