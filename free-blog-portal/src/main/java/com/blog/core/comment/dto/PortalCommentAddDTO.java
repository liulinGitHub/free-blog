package com.blog.core.comment.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalCommentAddDTO
 * @description: 添加评论信息
 * @Author: 950103
 * @Date: 2019/5/11 22:31
 **/
@Data
public class PortalCommentAddDTO {

    @ApiModelProperty("评论内容" )
    private String commentContent;

    @ApiModelProperty("所属文章id" )
    private String articleId;

    @ApiModelProperty("parent_id" )
    private String parentId;
}
