package com.blog.core.comment.entity.vo;

import com.blog.core.system.user.entity.PortalCommentUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: PortalCommentTree
 * @description: 文章评论返回前端展示对象
 * @author: liulin
 * @create: 2020-04-20 22:28
 */
@Data
public class PortalCommentTree {

    @ApiModelProperty( "评论id" )
    private String commentId;

    @ApiModelProperty( "评论内容" )
    private String commentContent;

    @ApiModelProperty( "评论者的作者名称" )
    private String author;

    @ApiModelProperty( "父id" )
    private String parentId;

    @ApiModelProperty( "评论时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date commentTime;

    @ApiModelProperty( "点赞数" )
    private Long approves;

    @ApiModelProperty( "作者头像图片" )
    private String avatarImage;

    @ApiModelProperty( "评论者的用户信息" )
    private PortalCommentUser commentUser;

    private List<PortalCommentTree> children;
}
