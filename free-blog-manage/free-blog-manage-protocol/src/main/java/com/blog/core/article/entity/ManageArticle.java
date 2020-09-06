package com.blog.core.article.entity;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: free-blog
 * @description: 查看文章信息返回对象
 * @author: 950103
 * @create: 2019-05-04 13:15
 */

@Data
public class ManageArticle extends BaseModel {

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

   	@ApiModelProperty("发表文章的作者ID" )
	private String articleUserId;

	@ApiModelProperty("文章状态 : 0 草稿 2 未审核 4 审核中 6 审核通过" )
	private ArticleStatusEnum articleStatus;

   	@ApiModelProperty("发布状态 0 未发布 1 已发布" )
	private ReleaseStatusEnum releaseStatus;

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

   	@ApiModelProperty("置顶状态" )
	private TopStatusEnum articleTopStatus;

   	@ApiModelProperty("是否开启评论" )
	private ArticleCommentsStatusEnum articleCommentsStatus;

   	@ApiModelProperty("是否精帖" )
	private ArticleFineNoteStatusEnum articleFineNoteStatus;

	@ApiModelProperty("删除标识" )
	private EnableEnum enable;

}
