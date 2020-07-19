package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: PortalArticleAddDTO
 * @description: 文章信息传参对象
 * @author: 950103
 * @create: 2019-05-06 09:42
 */
@Data
public class PortalArticleAddDTO {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty("标题" )
    @NotNull(message = "文章标题不能为空")
    private String articleTitle;

    @ApiModelProperty("文章描述" )
    private String articleDesc;

    @ApiModelProperty("文章图片" )
    private String articleImage;

    @ApiModelProperty("内容" )
    @NotNull(message = "文章内容不能为空")
    private String articleContent;

    @ApiModelProperty("文章标签" )
    private String tagId;

    @ApiModelProperty("文章分类" )
    private String categoryId;
}
