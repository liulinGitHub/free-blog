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
    private Integer articleId;

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
    private Integer articleUserId;

    @ApiModelProperty("发布状态 1 未发布 2 已发布" )
    private String releaseStatus;

    @ApiModelProperty("文章图片" )
    private String articleImage;

    @ApiModelProperty("文章类型" )
    private String articleType;

    @ApiModelProperty("审核状态 0 未审核 2 审核中 4 已审核" )
    private String auditStatus;

    @ApiModelProperty("置顶状态 0 未置顶 1 已置顶" )
    private String topStatus;

    @ApiModelProperty("评论开启状态 0 未开启 1 已开启" )
    private String commentStatus;

    @ApiModelProperty("是否精帖 0 不是精帖 1 是精帖" )
    private String fineNoteStatus;

    @ApiModelProperty("是否草稿 0 是草稿 1 不是草稿" )
    private String draftStatus;

    @ApiModelProperty("启用/禁用 0 启用 1 启用" )
    private String enable;

}
