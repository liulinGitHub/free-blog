package com.blog.core.comment.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassNmae: SysBaseCommentVO
 * @description: 文章评论返回前端展示对象
 * @Author: liulin
 * @Date: 2019/5/1 11:32
 **/
@Data
public class SysBaseArticleCommentVO {

    @ApiModelProperty(name = "评论id" )
    private String id;

    @ApiModelProperty(name = "评论内容" )
    private String commentContent;

    @ApiModelProperty(name = "评论者的作者名称" )
    private String author;

    @ApiModelProperty(name = "父id" )
    private String parentId;

    @ApiModelProperty(name = "所属文章id" )
    private String articleId;

    @ApiModelProperty(name = "是否为父级" )
    private String isParent;

    @ApiModelProperty(name = "评论时间" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date commentTime;

    @ApiModelProperty(name = "点赞数" )
    private Long approves;

    @ApiModelProperty(name = "作者头像图片" )
    private String avatar;

    private List<SysBaseArticleCommentVO> articleCommentVOList;
}
