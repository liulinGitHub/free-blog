package com.blog.core.article.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalArticleApprovalVO
 * @description: 文章点赞
 * @Author: liulin
 * @Date: 2020/3/28 10:32
 **/
@Data
public class PortalArticleApprovalVO {

    @ApiModelProperty("文章id" )
    private String articleTitleId;

    @ApiModelProperty("标题" )
    private String articleTitle;

    @ApiModelProperty("文章图片" )
    private String articleImages;
}
