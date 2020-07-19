package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalArticleApprovalDTO
 * @Description: 文章点赞参数
 * @date: 2020/7/20 0:20
 * @author: 950103
 * @Version 1.0
 */
@Data
public class PortalArticleApprovalDTO {

    @ApiModelProperty("被点赞的评论ID")
    private String subjectArticleId;

    @ApiModelProperty("点赞的用户ID")
    private String postUserId;

    @ApiModelProperty("被点赞的内容")
    private String articleTitle;
}
