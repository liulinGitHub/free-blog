package com.blog.core.comment.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalApprovalCommentDTO
 * @Description: 评论点赞参数
 * @date: 2020/7/19 2:11
 * @author: 950103
 * @Version 1.0
 */
@Data
public class PortalApprovalCommentDTO {

    @ApiModelProperty("被点赞的评论ID")
    private Integer subjectCommentId;

    @ApiModelProperty("点赞的用户ID")
    private Integer postUserId;

    @ApiModelProperty("被点赞的内容")
    private String commentContent;
}
