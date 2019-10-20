package com.blog.core.articlecategory.dao;

import com.blog.core.articlecategory.entity.vo.PortalCategoryVO;
import org.springframework.stereotype.Repository;

/**
 * @program: PortalCategoryMapper
 * @description:
 * @author: liulin
 * @create: 2019-10-09 17:16
 * @Version: 1.0
 */
@Repository("portalArticleCategoryMapper")
public interface PortalArticleCategoryMapper {

    /**
     * 根据id查询评论信息
     * @param categoryId
     * @return
     */
    PortalCategoryVO selectCategoryById(String categoryId);
}
