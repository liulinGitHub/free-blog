package com.blog.core.articlecategory.service;

import com.blog.core.articlecategory.entity.vo.PortalCategoryVO;
import java.util.List;

/**
 * @program: free-blog
 * @description:
 * @author: liulin
 * @create: 2019-05-05 15:47
 */
public interface PortalArticleCategoryService {

    List<PortalCategoryVO> queryCategoryByPage();

    /**
     * 根据文章分类id查询
     * @param CategoryId
     * @return
     */
    PortalCategoryVO findCategoryById(String CategoryId);
}
