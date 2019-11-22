package com.blog.core.articlecategory.service.impl;

import com.blog.core.article.entity.domain.ManageArticle;
import com.blog.core.articlecategory.dao.ManageArticleCategoryMapper;
import com.blog.core.articlecategory.entity.domain.ManageArticleCategory;
import com.blog.core.articlecategory.entity.dto.ManageCategoryAddDTO;
import com.blog.core.articlecategory.entity.dto.ManageCategoryEditDTO;
import com.blog.core.articlecategory.entity.vo.ManageCategoryVO;
import com.blog.core.articlecategory.service.ManageArticleCategoryService;
import com.blog.core.common.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: ManageArticleCategoryServiceImpl
 * @description: 文章分类信息service
 * @author: liulin
 * @create: 2019-11-22 17:54
 * @Version: 1.0
 */
@Service("manageArticleCategoryService")
public class ManageArticleCategoryServiceImpl implements ManageArticleCategoryService {

    @Autowired
    private ManageArticleCategoryMapper manageArticleCategoryMapper;

    @Override
    public List<ManageCategoryVO> queryArticleCategoryByPage() {
        List<ManageCategoryVO> manageCategoryVOList = this.manageArticleCategoryMapper.selectArticleCategoryByPage();
        return manageCategoryVOList;
    }

    @Override
    public ManageCategoryVO queryArticleCategoryByCategoryId(String categoryId) {
        ManageCategoryVO manageCategoryVO = this.manageArticleCategoryMapper.selectArticleCategoryByCategoryId(categoryId);
        return manageCategoryVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addArticleCategory(ManageCategoryAddDTO manageCategoryAddDTO) {
        ManageArticleCategory manageArticleCategory = MapperUtils.mapperBean(manageCategoryAddDTO, ManageArticleCategory.class);
        // TODO 文章分类id没有设置
        manageArticleCategory.setCategoryId("1");
        manageArticleCategory.setCreateId("1");
        manageArticleCategory.setCreateTime(new Date());
        this.manageArticleCategoryMapper.insertArticleCategory(manageArticleCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editArticleCategory(ManageCategoryEditDTO manageCategoryEditDTO){
        ManageArticleCategory manageArticleCategory = MapperUtils.mapperBean(manageCategoryEditDTO, ManageArticleCategory.class);
        // TODO 文章分类修改人id没有设置
        manageArticleCategory.setUpdateId("1");
        manageArticleCategory.setUpdateTime(new Date());
        this.manageArticleCategoryMapper.updateArticleCategory(manageArticleCategory);
    }
}
