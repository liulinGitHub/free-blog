package com.blog.core.article.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: free-blog
 * @description: 查看文章信息返回对象
 * @author: liulin
 * @create: 2019-05-04 13:15
 */

@Data
public class ManageArticle extends BaseModel {

   	@ApiModelProperty(name = "标题" )
	private String articleTitle;

   	@ApiModelProperty(name = "发布日期" )
	private Date releaseDate;

   	@ApiModelProperty(name = "内容" )
	private String articleContent;

   	@ApiModelProperty(name = "发表文章的作者ID" )
	private String articleUserId;

	@ApiModelProperty(name = "文章状态 : 0,草稿 1 未审核 2 审核通过" )
	private String articleStatus;

   	@ApiModelProperty(name = "删除标识" )
	private String isEnable;

   	@ApiModelProperty(name = "发布状态 1 未发布 2 已发布" )
	private String releaseStatus;

   	@ApiModelProperty(name = "文章标签" )
	private String articleTag;

   	@ApiModelProperty(name = "文章图片" )
	private String articleImages;

   	@ApiModelProperty(name = "点赞数" )
	private Long approves;

	@ApiModelProperty(name = "评论数" )
	private Long comments;

   	@ApiModelProperty(name = "热度" )
	private Long temperature;

   	@ApiModelProperty(name = "浏览人数" )
	private Long articleClick;

   	@ApiModelProperty(name = "文章的模式" )
	private String articleType;

   	@ApiModelProperty(name = "是否置顶" )
	private String articleUp;

   	@ApiModelProperty(name = "是否开启评论" )
	private String isComments;

   	@ApiModelProperty(name = "是否精帖" )
	private String articleFineNote;

	@ApiModelProperty(name = "是否推荐" )
	private String recommendStatus;

   	@ApiModelProperty(name = "栏目ID" )
	private String typeId;

   	@ApiModelProperty(name = "评论id" )
	private String commentsId;

	@ApiModelProperty(name = "分类id" )
	private String categoryId;

}
