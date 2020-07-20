package com.blog.core.comment.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.CommentTypeEnum;
import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: ManageComment
 * @description: 评论信息
 * @Author: liulin
 * @Date: 2020/2/2 21:22
 **/
@Data
public class ManageComment extends BaseModel {

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

    @ApiModelProperty("评论所属")
    private CommentTypeEnum commentType;

    @ApiModelProperty("评论所属")
    private String commentBelongId;

    @ApiModelProperty("启用/停用")
    private EnableEnum enable;
}
