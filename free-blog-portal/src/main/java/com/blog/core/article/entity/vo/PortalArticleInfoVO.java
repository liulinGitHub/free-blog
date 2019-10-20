package com.blog.core.article.entity.vo;

import com.blog.core.tag.entity.vo.PortalTagVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: free-blog
 * @description: 查看文章信息返回对象
 * @author: liulin
 * @create: 2019-05-04 15:15
 */
@Data
public class PortalArticleInfoVO {

    @ApiModelProperty(name = "ID" )
    private String id;

    @ApiModelProperty(name = "标题" )
    private String articleTitle;

    @ApiModelProperty(name = "发布日期" )
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date releaseDate;

    @ApiModelProperty(name = "文章内容" )
    private String articleContent;

    @ApiModelProperty(name = "标签ID" )
    private String tagId;

    @ApiModelProperty(name = "文章图片" )
    private String articleImages;

    @ApiModelProperty(name = "评论数" )
    private Long comments;

    @ApiModelProperty(name = "点赞数" )
    private Long approves;

    @ApiModelProperty(name = "喜欢" )
    private Long likeNumber;

    @ApiModelProperty(name = "浏览人数" )
    private Long readNumber;

    @ApiModelProperty(name = "所属分类ID" )
    private String sortArticleId;

    @ApiModelProperty(name = "文章的模式" )
    private String articleType;

    @ApiModelProperty(name = "是否置顶" )
    private String articleTop;

    @ApiModelProperty(name = "是否开启评论" )
    private String commentStatus;

    @ApiModelProperty(name = "是否精帖" )
    private String articleFineNote;

    @ApiModelProperty(name = "创建时间" )
    private Date createTime;

    @ApiModelProperty(name = "分类id" )
    private String categoryId;

    @ApiModelProperty(name = "发表文章的作者" )
    private String articleUserId;

    @ApiModelProperty(name = "发表文章的作者" )
    private String articleAuthor;

    @ApiModelProperty(name = "发表文章的作者的头像" )
    private String articleAuthorImage;

    private List<PortalTagVO> portalTagVOList;
}
