package com.blog.core.comment.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @ClassName: PortalArticleCommentVO
 * @description: 文章评论返回前端展示对象
 * @author: 950103
 * @create: 2019-10-09 17:30
 * @Version: 1.0
 */
@Data
public class PortalCommentVO {

    @ApiModelProperty( "评论id" )
    private String id;

    @ApiModelProperty( "评论内容" )
    private String commentContent;

    @ApiModelProperty( "评论者的作者名称" )
    private String author;

    @ApiModelProperty( "父id" )
    private String parentId;

    @ApiModelProperty( "是否为父级" )
    private String isParent;

    @ApiModelProperty( "评论时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date commentTime;

    @ApiModelProperty( "点赞数" )
    private Long approves;

    @ApiModelProperty( "作者头像图片" )
    private String avatarImage;

    private List<PortalCommentVO> commentVOList;
}
