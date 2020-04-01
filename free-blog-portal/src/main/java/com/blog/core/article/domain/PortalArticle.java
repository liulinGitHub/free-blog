package com.blog.core.article.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author  Hunter
 * @Date 2019-04-07
 */

@Data
public class PortalArticle extends BaseModel {

	@ApiModelProperty("文章id" )
	private String articleTitleId;

   	@ApiModelProperty("标题" )
	private String articleTitle;

   	@ApiModelProperty("发布日期" )
	private Date releaseDate;

   	@ApiModelProperty("内容" )
	private String articleContent;

   	@ApiModelProperty("发表文章的作者ID" )
	private String articleUserId;

	@ApiModelProperty("文章状态 : 0,草稿 1 未审核 2 审核通过" )
	private String articleStatus;

   	@ApiModelProperty("删除标识" )
	private String isEnable;

   	@ApiModelProperty("发布状态 1 未发布 2 已发布" )
	private String releaseStatus;

   	@ApiModelProperty("文章标签" )
	private String articleTag;

   	@ApiModelProperty("文章图片" )
	private String articleImages;

   	@ApiModelProperty("点赞数" )
	private Long approves;

	@ApiModelProperty("评论数" )
	private Long comments;

   	@ApiModelProperty("热度" )
	private Long temperature;

   	@ApiModelProperty("浏览人数" )
	private Long articleClick;

   	@ApiModelProperty("文章的模式" )
	private String articleType;

   	@ApiModelProperty("是否置顶" )
	private String articleUp;

   	@ApiModelProperty("是否开启评论" )
	private String isComments;

   	@ApiModelProperty("是否精帖" )
	private String articleFineNote;

   	@ApiModelProperty("栏目ID" )
	private String typeId;

   	@ApiModelProperty("评论id" )
	private String commentsId;

	@ApiModelProperty("分类id" )
	private String categoryId;

}
