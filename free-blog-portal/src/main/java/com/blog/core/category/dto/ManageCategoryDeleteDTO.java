package com.blog.core.category.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassNmae: ArticleCategoryQueryDTO
 * @description:
 * @Author: 950103
 * @Date: 2019/7/20 18:50
 **/
@Data
public class ManageCategoryDeleteDTO {

    private List<Integer> categoryIdList;
}
