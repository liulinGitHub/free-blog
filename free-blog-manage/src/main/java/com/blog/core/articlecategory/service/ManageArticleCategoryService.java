package com.blog.core.articlecategory.service;

import com.blog.core.articlecategory.entity.dto.ManageCategoryAddDTO;
import com.blog.core.articlecategory.entity.dto.ManageCategoryEditDTO;
import com.blog.core.articlecategory.entity.vo.ManageCategoryVO;

import java.util.List;

/**
 * @program: ManageArticleCategoryService
 * @description:
 * @author: liulin
 * @create: 2019-11-22 17:53
 * @Version: 1.0
 */
public interface ManageArticleCategoryService {

    /**
     * 分页查询文章分类信息
     *
     * @return
     */
    List<ManageCategoryVO> queryArticleCategoryByPage();

    /**
     * 根据文章分类id查询
     *
     * @param categoryId
     * @return
     */
    ManageCategoryVO queryArticleCategoryByCategoryId(String categoryId);

    /**
     * 添加文章分类信息
     *
     * @param manageCategoryAddDTO
     */
    void addArticleCategory(ManageCategoryAddDTO manageCategoryAddDTO);

    /**
     * 修改文章分类信息
     *
     * @param manageCategoryEditDTO
     */
    void editArticleCategory(ManageCategoryEditDTO manageCategoryEditDTO);
}
