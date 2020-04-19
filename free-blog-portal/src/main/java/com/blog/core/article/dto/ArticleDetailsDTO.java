package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ArticleDetailsDTO
 * @Description: 文章查询详情参数
 * @Author: liulin
 * @Date: 2020/4/19 20:18
 * @Version 1.0
 */
@Data
public class ArticleDetailsDTO {

    @ApiModelProperty("文章id" )
    private String articleTitleId;
}
