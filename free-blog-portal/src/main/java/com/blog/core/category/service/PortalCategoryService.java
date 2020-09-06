package com.blog.core.category.service;

import com.blog.core.category.vo.PortalCategoryVO;
import com.blog.core.common.enums.CategoryTypeEnum;

import java.util.List;

/**
 * @ClassNmae: PortalCategoryService
 * @description: 分类Service
 * @author: 950103
 * @create: 2019-05-05 15:47
 */
public interface PortalCategoryService {

    /**
     * 根据分类类型查询分类
     *
     * @param categoryTypeEnum
     * @return
     */
    List<PortalCategoryVO> queryCategoryByCategoryType(CategoryTypeEnum categoryTypeEnum);

    /**
     * 根据文章id查询所属分类
     *
     * @param articleId
     * @return
     */
    List<PortalCategoryVO> queryCategoryByArticleId(Integer articleId);
}
