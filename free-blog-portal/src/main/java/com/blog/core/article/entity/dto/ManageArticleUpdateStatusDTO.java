package com.blog.core.article.entity.dto;

import com.blog.core.common.enums.ArticleUpdateStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: free-blog
 * @description: 文章提交审核/保存草稿传参
 * @author: liulin
 * @create: 2019-05-06 09:32
 */
@Data
public class ManageArticleUpdateStatusDTO {

    @ApiModelProperty(name = "id" )
    private String id;

    private String recommendStatus;

    private String articleFineNoteStatus;

    private String commentStatus;

    private String articleTopStatus;

    private String releaseStatus;

    private ArticleUpdateStatusEnum articleUpdateStatusEnum;
}
