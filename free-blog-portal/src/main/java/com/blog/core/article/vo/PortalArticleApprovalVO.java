package com.blog.core.article.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 文章点赞
 * @Author: 950103
 * @Date: 2020/3/28 10:32
 * @version: 1.0
 **/
@Data
public class PortalArticleApprovalVO {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty("标题" )
    private String articleTitle;

    @ApiModelProperty("文章图片" )
    private String articleImage;
}
