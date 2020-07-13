package com.blog.core.category.service.impl;

import com.blog.core.category.dao.PortalCategoryMapper;
import com.blog.core.category.vo.PortalCategoryVO;
import com.blog.core.category.service.PortalCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassNmae: PortalCategoryServiceImpl
 * @description:
 * @author: 950103
 * @create: 2019-05-05 15:49
 */
@Slf4j
@Service("portalCategoryService")
public class PortalCategoryServiceImpl implements PortalCategoryService {

    @Autowired
    private PortalCategoryMapper portalCategoryMapper;


    @Override
    public List<PortalCategoryVO> queryCategoryByPage() {
        return null;
    }

    @Override
    public PortalCategoryVO findCategoryById(String categoryId) {
        PortalCategoryVO CategoryVO = this.portalCategoryMapper.selectCategoryById(categoryId);
        return CategoryVO;
    }

}
