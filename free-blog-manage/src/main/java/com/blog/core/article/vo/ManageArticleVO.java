package com.blog.core.article.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: ManageArticleInfoVO
 * @description: 文章信息返回参数
 * @author: 950103
 * @create: 2019-11-22 14:51
 * @Version: 1.0
 */
@Data
public class ManageArticleVO {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty("标题" )
    private String articleTitle;

    @ApiModelProperty("发布日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date releaseDate;

    @ApiModelProperty("文章内容-html" )
    private String articleContentHtml;

    @ApiModelProperty("文章内容-markdown" )
    private String articleContentMarkDown;

    @ApiModelProperty("发表文章的作者ID" )
    private String articleUserId;

    @ApiModelProperty("文章状态 : 0 草稿 2 未审核 4 审核中 6 审核通过" )
    private String articleStatus;

    @ApiModelProperty("发布状态 0 未发布 1 已发布" )
    private String releaseStatus;

    @ApiModelProperty("文章图片" )
    private String articleImage;

    @ApiModelProperty("点赞数" )
    private Integer approvesNumber;

    @ApiModelProperty("评论数" )
    private Integer commentsNumber;

    @ApiModelProperty("喜欢数" )
    private Integer likeNumber;

    @ApiModelProperty("浏览人数" )
    private Integer readNumber;

    @ApiModelProperty("文章类型" )
    private String articleType;

    @ApiModelProperty("置顶状态" )
    private String articleTopStatus;

    @ApiModelProperty("是否开启评论" )
    private String articleCommentsStatus;

    @ApiModelProperty("是否精帖" )
    private String articleFineNoteStatus;

    @ApiModelProperty("删除标识" )
    private String isEnable;

    @ApiModelProperty("发表文章的作者的头像" )
    private String articleAuthorImage;

    @ApiModelProperty("发表文章的作者" )
    private String articleAuthor;
}
