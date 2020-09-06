package com.blog.core.article.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @Description: 文章相关信息返回前端参数
 * @Author: 950103
 * @Create: 2019-05-04 15:15
 * @Version 1.0
 */
@Data
public class PortalArticleInfoVO {

    @ApiModelProperty("文章id" )
    private Integer articleId;

    @ApiModelProperty("点赞数" )
    private Integer approvesNumber;

    @ApiModelProperty("评论数" )
    private Integer commentsNumber;

    @ApiModelProperty("喜欢数" )
    private Integer likeNumber;

    @ApiModelProperty("浏览人数" )
    private Integer readNumber;
}
