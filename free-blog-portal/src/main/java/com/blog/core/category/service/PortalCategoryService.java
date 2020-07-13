package com.blog.core.category.service;

import com.blog.core.category.vo.PortalCategoryVO;
import java.util.List;

/**
 * @ClassNmae: PortalCategoryService
 * @description:
 * @author: 950103
 * @create: 2019-05-05 15:47
 */
public interface PortalCategoryService {

    List<PortalCategoryVO> queryCategoryByPage();

    /**
     * 根据文章分类id查询
     * @param CategoryId
     * @return
     */
    PortalCategoryVO findCategoryById(String CategoryId);
}
