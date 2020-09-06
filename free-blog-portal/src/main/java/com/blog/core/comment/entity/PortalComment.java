package com.blog.core.comment.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * @ClassName: PortalComment
 * @description: 评论
 * @Author: 950103
 * @Date: 2019-04-07 13:36
 */
@Data
@Api(value = "评论")
public class PortalComment extends BaseModel {

	@ApiModelProperty("评论ID" )
	private Integer commentId;

   	@ApiModelProperty("评论内容" )
	private String commentContent;

   	@ApiModelProperty("评论者的用户id" )
	private Integer commentUserId;

   	@ApiModelProperty("父id" )
	private Integer parentId;

   	@ApiModelProperty("所属文章id" )
	private Integer articleId;

   	@ApiModelProperty("评论时间" )
	private Date commentTime;

   	@ApiModelProperty("点赞数" )
	private Long approves;

   	@ApiModelProperty("是否删除" )
	private String enable;
}
