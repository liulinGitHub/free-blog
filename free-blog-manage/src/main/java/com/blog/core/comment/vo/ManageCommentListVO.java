package com.blog.core.comment.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ManageCommentVO
 * @description:
 * @author: 950103
 * @create: 2019-12-16 16:08
 * @Version: 1.0
 */
@Data
public class ManageCommentListVO {

    @ApiModelProperty("评论信息ID")
    private String commentId;

    @ApiModelProperty("评论信息")
    private String commentContent;

    @ApiModelProperty("评论人Id")
    private String commentUserId;

    @ApiModelProperty("被评论人Id")
    private String commentParentId;

    @ApiModelProperty("是否父级id")
    private String isParent;

    @ApiModelProperty("评论时间")
    private Date commentTime;

    private List<ManageCommentListVO> manageCommentList;
}
