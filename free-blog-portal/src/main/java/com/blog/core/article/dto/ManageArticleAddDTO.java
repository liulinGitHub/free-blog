package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ManageArticleAddDTO
 * @description: 文章信息传参对象
 * @author: 950103
 * @create: 2019-05-06 09:42
 */
@Data
public class ManageArticleAddDTO {

    @ApiModelProperty(name = "文章id" )
    private Integer articleId;

    @ApiModelProperty(name = "标题" )
    private String articleTitle;

    @ApiModelProperty(name = "内容" )
    private String articleContent;

    @ApiModelProperty(name = "文章标签" )
    private String articleTag;

    @ApiModelProperty(name = "文章图片" )
    private String articleImage;
}
