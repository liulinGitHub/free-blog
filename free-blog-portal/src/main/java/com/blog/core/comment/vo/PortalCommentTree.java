package com.blog.core.comment.vo;

import com.blog.core.system.user.entity.PortalCommonUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: PortalCommentTree
 * @description: 文章评论返回前端展示对象
 * @author: 950103
 * @create: 2020-07-17 17:18
 * @Version: 1.0
 */
@Data
public class PortalCommentTree {

	@ApiModelProperty( "评论id" )
	private String commentId;

	@ApiModelProperty( "评论内容" )
	private String commentContent;

	@ApiModelProperty( "父id" )
	private String parentId;

	@ApiModelProperty( "评论时间" )
	@JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
	private Date commentTime;

	@ApiModelProperty( "点赞数" )
	private Long approves;

	@ApiModelProperty( "评论者的用户信息" )
	private PortalCommonUser commentUser;

	@ApiModelProperty( "评论者回复信息" )
	private List<PortalCommentTree> replyChildren;
}
