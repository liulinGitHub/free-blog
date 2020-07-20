package com.blog.core.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: ManageArticleUpdateStatusDTO
 * @description: 文章提交审核/保存草稿传参
 * @author: 950103
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
}
