package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ManageArticleCheckDTO
 * @description: 文章提交审核/保存草稿传参
 * @author: 950103
 * @create: 2019-05-06 09:32
 */
@Data
public class ManageArticleCheckDTO {

    @ApiModelProperty(name = "标题" )
    private String articleTitle;

    @ApiModelProperty(name = "内容" )
    private String articleContent;

    @ApiModelProperty(name = "文章标签" )
    private String articleTag;

    @ApiModelProperty(name = "文章图片" )
    private String articleImage;
}
