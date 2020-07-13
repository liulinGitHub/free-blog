package com.blog.core.article.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: PortalArticle
 * @description: 文章实体
 * @Author: 950103
 * @Date: 2020/4/19 11:26
 **/
@Data
public class PortalArticle extends BaseModel {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty("标题" )
    private String articleTitle;

    @ApiModelProperty("发布日期" )
    private Date releaseDate;

    @ApiModelProperty("文章内容-html" )
    private String articleContentHtml;

    @ApiModelProperty("文章内容-markdown" )
    private String articleContentMarkDown;

    @ApiModelProperty("文章描述" )
    private String articleDesc;

    @ApiModelProperty("发表文章的作者ID" )
    private String articleUserId;

    @ApiModelProperty("文章状态 : 0,草稿 1 未审核 2 审核通过" )
    private String articleStatus;

    @ApiModelProperty("发布状态 1 未发布 2 已发布" )
    private String releaseStatus;

    @ApiModelProperty("文章图片" )
    private String articleImage;

    @ApiModelProperty("文章类型" )
    private String articleType;

    @ApiModelProperty("置顶状态 0 未置顶 1 已置顶" )
    private String articleTopStatus;

    @ApiModelProperty("评论开启状态 0 未开启 1 已开启" )
    private String articleCommentStatus;

    @ApiModelProperty("是否精帖 0 不是精帖 1 是精帖" )
    private String articleFineNoteStatus;

    @ApiModelProperty("启用/禁用 0 启用 1 启用" )
    private String enable;

}
