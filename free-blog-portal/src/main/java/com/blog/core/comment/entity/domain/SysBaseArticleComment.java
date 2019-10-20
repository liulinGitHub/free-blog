package com.blog.core.comment.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: SysBaseArticleComment
 * @description: 文章评论服务
 * @Author: liulin
 * @Date: 2019-04-07 13:36
 */

@Data
@Api(value = "文章评论服务")
public class SysBaseArticleComment extends BaseModel {

	/**
	 * 评论内容
	 */
   	@ApiModelProperty(name = "comment_content" )
	private String commentContent;

	/**
	 * 评论者的用户id
	 */
   	@ApiModelProperty(name = "comment_user_id" )
	private String commentUserId;

	/**
	 * 父id
	 */
   	@ApiModelProperty(name = "parent_id" )
	private String parentId;

	/**
	 * 所属文章id
	 */
   	@ApiModelProperty(name = "article_id" )
	private String articleId;

	/**
	 * 是否为父级
	 */
   	@ApiModelProperty(name = "is_parent" )
	private String isParent;

	/**
	 * 评论时间
	 */
   	@ApiModelProperty(name = "comment_time" )
	private Date commentTime;

	/**
	 * 点赞数
	 */
   	@ApiModelProperty(name = "approves" )
	private Long approves;

	/**
	 * 是否删除
	 */
   	@ApiModelProperty(name = "is_enable" )
	private String isEnable;
}
