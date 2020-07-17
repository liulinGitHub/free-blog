package com.blog.core.article.vo;

import com.blog.core.tag.entity.vo.PortalTagVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassNmae: PortalArticleListVO
 * @Description: 文章列表 主页面展示参数
 * @Author: 950103
 * @Date: 2019/4/7 9：55
 **/

@Data
public class PortalArticleListVO {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty(name = "标题" )
    private String articleTitle;

    @ApiModelProperty(name = "发布日期" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date articleReleaseDate;

    @ApiModelProperty("文章描述" )
    private String articleDesc;

    @ApiModelProperty(name = "文章图片" )
    private String articleImage;

    @ApiModelProperty("置顶状态 0 未置顶 1 已置顶" )
    private String articleTopStatus;

    @ApiModelProperty("是否精帖 0 不是精帖 1 是精帖" )
    private String articleFineNoteStatus;

    @ApiModelProperty(name = "创建时间" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty(name = "发表文章的作者ID" )
    private String articleUserId;

    @ApiModelProperty(name = "发表文章的作者" )
    private String articleAuthor;

    @ApiModelProperty(name = "发表文章的作者的头像" )
    private String articleAuthorImage;

    @ApiModelProperty(name = "文章标签" )
    private List<PortalTagVO> tags;

    @ApiModelProperty("文章相关信息" )
    private PortalArticleInfoVO meta;
}
