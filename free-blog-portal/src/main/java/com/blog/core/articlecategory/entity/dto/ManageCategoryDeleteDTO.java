package com.blog.core.articlecategory.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassNmae: ArticleCategoryQueryDTO
 * @description:
 * @Author: liulin
 * @Date: 2019/7/20 18:50
 **/
@Data
public class ManageCategoryDeleteDTO {

    private List<String> categoryIdList;
}
