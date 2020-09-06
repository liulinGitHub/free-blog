package com.blog.core.comment.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: ManageCommentDetailVO
 * @description: 评论详情vo
 * @author: 950103
 * @create: 2019-12-19 09:47
 * @Version: 1.0
 */
@Data
public class ManageCommentDetailVO {

    @ApiModelProperty("评论信息ID")
    private Integer commentId;

    @ApiModelProperty("评论信息")
    private String commentContent;

    @ApiModelProperty("评论人Id")
    private Integer commentUserId;

    @ApiModelProperty("被评论人Id")
    private Integer commentParentId;

    @ApiModelProperty("是否父级id")
    private String isParent;

    @ApiModelProperty("评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentTime;

    private List<ManageCommentDetailVO> manageCommentList;
}
