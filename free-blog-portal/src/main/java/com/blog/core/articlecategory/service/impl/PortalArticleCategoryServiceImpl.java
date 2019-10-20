package com.blog.core.articlecategory.service.impl;

import com.blog.core.articlecategory.dao.PortalArticleCategoryMapper;
import com.blog.core.articlecategory.entity.vo.PortalCategoryVO;
import com.blog.core.articlecategory.service.PortalArticleCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @program: free-blog
 * @description:
 * @author: liulin
 * @create: 2019-05-05 15:49
 */
@Slf4j
@Service("portalArticleCategoryService")
public class PortalArticleCategoryServiceImpl implements PortalArticleCategoryService {

    @Autowired
    private PortalArticleCategoryMapper portalArticleCategoryMapper;


    @Override
    public List<PortalCategoryVO> queryCategoryByPage() {
        return null;
    }

    @Override
    public PortalCategoryVO findCategoryById(String categoryId) {
        PortalCategoryVO CategoryVO = this.portalArticleCategoryMapper.selectCategoryById(categoryId);
        return CategoryVO;
    }

}
