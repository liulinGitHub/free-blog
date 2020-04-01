package com.blog.core.comment.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * @Description: PortalComment
 * @description: 文章评论服务
 * @Author: liulin
 * @Date: 2019-04-07 13:36
 */

@Data
@Api(value = "文章评论服务")
public class PortalArticleComment extends BaseModel {

	@ApiModelProperty("评论ID" )
	private String commentId;

   	@ApiModelProperty("评论内容" )
	private String commentContent;

   	@ApiModelProperty("评论者的用户id" )
	private String commentUserId;

   	@ApiModelProperty("父id" )
	private String parentId;

   	@ApiModelProperty("所属文章id" )
	private String articleId;

   	@ApiModelProperty("是否为父级" )
	private String isParent;

   	@ApiModelProperty("评论时间" )
	private Date commentTime;

   	@ApiModelProperty("点赞数" )
	private Long approves;

   	@ApiModelProperty("是否删除" )
	private String isEnable;
}
