package com.blog.core.comment.dto;

import com.blog.core.common.enums.CommentTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ManageCommentAddDTO
 * @description: 保存评论
 * @author: 950103
 * @create: 2019-12-16 16:09
 * @Version: 1.0
 */
@Data
public class ManageCommentAddDTO {

    @ApiModelProperty("评论信息")
    private String commentContent;

    @ApiModelProperty("评论人Id")
    private Integer commentUserId;

    @ApiModelProperty("被评论人Id")
    private Integer commentParentId;

    @ApiModelProperty("评论所属")
    private CommentTypeEnum commentType;

    @ApiModelProperty("评论所属")
    private Integer belongId;
}
