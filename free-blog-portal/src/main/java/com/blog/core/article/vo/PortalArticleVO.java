package com.blog.core.article.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae:SysBaseArticleVO
 * @description:文章返回前端传参对象
 * @Author:liulin
 * @Date: 2019/4/7 9：55
 **/

@Data
public class PortalArticleVO {

    @ApiModelProperty(name = "ID" )
    private String id;

    @ApiModelProperty(name = "标题" )
    private String articleTitle;

    @ApiModelProperty(name = "发布日期" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date releaseDate;

    @ApiModelProperty(name = "文章内容" )
    private String articleContent;

    @ApiModelProperty(name = "发布状态" )
    private String releaseStatus;

    @ApiModelProperty(name = "标签ID" )
    private String tagId;

    @ApiModelProperty(name = "文章图片" )
    private String articleImages;

    @ApiModelProperty(name = "评论数" )
    private Long comments;

    @ApiModelProperty(name = "点赞数" )
    private Long approves;

    @ApiModelProperty(name = "喜欢" )
    private Long likeNumber;

    @ApiModelProperty(name = "浏览人数" )
    private Long readNumber;

    @ApiModelProperty(name = "所属分类ID" )
    private String sortArticleId;

    @ApiModelProperty(name = "文章的模式" )
    private String articleType;

    @ApiModelProperty(name = "是否置顶" )
    private String articleUp;

    @ApiModelProperty(name = "是否开启评论" )
    private String isComments;

    @ApiModelProperty(name = "是否精帖" )
    private String articleFineNote;

    @ApiModelProperty(name = "栏目ID" )
    private String typeId;

    @ApiModelProperty(name = "创建时间" )
    private Date createTime;

    @ApiModelProperty(name = "分类id" )
    private String categoryId;

    @ApiModelProperty(name = "发表文章的作者" )
    private String articleUserId;

    @ApiModelProperty(name = "发表文章的作者" )
    private String articleAuthor;

    @ApiModelProperty(name = "发表文章的作者的头像" )
    private String articleAuthorImage;
}
