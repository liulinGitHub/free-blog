package com.blog.core.comment.dto;

import com.blog.core.common.enums.CommentBelongTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ManageCommentAddDTO
 * @description: 保存评论
 * @author: liulin
 * @create: 2019-12-16 16:09
 * @Version: 1.0
 */
@Data
public class ManageCommentAddDTO {

    @ApiModelProperty("评论信息")
    private String commentContent;

    @ApiModelProperty("评论人Id")
    private String commentUserId;

    @ApiModelProperty("被评论人Id")
    private String commentParentId;

    @ApiModelProperty("评论所属")
    private CommentBelongTypeEnum commentBelongType;

    @ApiModelProperty("评论所属")
    private String belongId;
}
