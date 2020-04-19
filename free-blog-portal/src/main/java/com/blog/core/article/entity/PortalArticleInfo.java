package com.blog.core.article.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalArticleInfo
 * @Description: 文章相关信息实体
 * @Author: liulin
 * @Date: 2020/4/19 21:09
 * @Version 1.0
 */
@Data
public class PortalArticleInfo extends BaseModel {

    @ApiModelProperty("文章相关信息id" )
    private String articleInfoId;

    @ApiModelProperty("文章id" )
    private String articleTitleId;

    @ApiModelProperty("点赞数" )
    private Long approveNumber;

    @ApiModelProperty("评论数" )
    private Long commentsNumber;

    @ApiModelProperty("热度" )
    private Long likeNumber;

    @ApiModelProperty("浏览人数" )
    private Long readNumber;
}
