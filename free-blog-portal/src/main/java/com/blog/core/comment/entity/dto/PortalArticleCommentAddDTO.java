package com.blog.core.comment.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ArticleCommentAddDTO
 * @description: 添加评论信息
 * @Author: liulin
 * @Date: 2019/5/11 22:31
 **/
@Data
public class PortalArticleCommentAddDTO {

    /**
     * 评论内容
     */
    @ApiModelProperty(name = "comment_content" )
    private String commentContent;

    /**
     * 所属文章id
     */
    @ApiModelProperty(name = "article_id" )
    private String articleId;

    /**
     * 父id
     */
    @ApiModelProperty(name = "parent_id" )
    private String parentId;
}
