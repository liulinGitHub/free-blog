package com.blog.core.article.vo;

import com.blog.core.tag.vo.PortalTagVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @ClassNmae: PortalArticleDetailsVO
 * @Description: 文章详情信息
 * @Author: 950103
 * @Date: 2020/4/19 19:16
 * @Version 1.0
 */
@Data
public class PortalArticleDetailsVO {

    @ApiModelProperty("文章id" )
    private String articleId;

    @ApiModelProperty("标题" )
    private String articleTitle;

    @ApiModelProperty("发布日期" )
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date articleReleaseDate;

    @ApiModelProperty("文章内容-html" )
    private String articleContentHtml;

    @ApiModelProperty("文章内容-markdown" )
    private String articleContentMarkDown;

    @ApiModelProperty("评论开启状态 0 未开启 1 已开启" )
    private String commentStatus;

    @ApiModelProperty("发表文章的作者ID" )
    private String articleUserId;

    @ApiModelProperty("发表文章的作者" )
    private String articleAuthor;

    @ApiModelProperty("文章标签" )
    private List<PortalTagVO> tags;

    @ApiModelProperty("文章相关信息" )
    private PortalArticleInfoVO meta;
}
