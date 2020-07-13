package com.blog.core.category.dao;

import com.blog.core.category.vo.PortalCategoryVO;
import org.springframework.stereotype.Repository;

/**
 * @program: PortalCategoryMapper
 * @description: 文章分类Mapper
 * @author: 950103
 * @create: 2019-10-09 17:16
 * @Version: 1.0
 */
@Repository("portalCategoryMapper")
public interface PortalCategoryMapper {

    /**
     * 根据id查询评论信息
     * @param categoryId
     * @return
     */
    PortalCategoryVO selectCategoryById(String categoryId);
}
