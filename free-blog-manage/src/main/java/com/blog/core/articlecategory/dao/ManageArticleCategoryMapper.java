package com.blog.core.articlecategory.dao;

import com.blog.core.articlecategory.entity.domain.ManageArticleCategory;
import com.blog.core.articlecategory.entity.vo.ManageCategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: ManageArticleCategoryMapper
 * @description:
 * @author: liulin
 * @create: 2019-11-22 17:55
 * @Version: 1.0
 */
@Repository("manageArticleCategoryMapper")
public interface ManageArticleCategoryMapper {

    /**
     * 分页查询文章分类信息
     *
     * @return
     */
    List<ManageCategoryVO> selectArticleCategoryByPage();

    /**
     * 根据文章分类id查询
     *
     * @param categoryId
     * @return
     */
    ManageCategoryVO selectArticleCategoryByCategoryId(String categoryId);

    /**
     * 添加文章分类信息
     *
     * @param manageArticleCategory
     */
    void insertArticleCategory(ManageArticleCategory manageArticleCategory);

    /**
     * 修改文章分类信息
     *
     * @param manageArticleCategory
     */
    void updateArticleCategory(ManageArticleCategory manageArticleCategory);
}
