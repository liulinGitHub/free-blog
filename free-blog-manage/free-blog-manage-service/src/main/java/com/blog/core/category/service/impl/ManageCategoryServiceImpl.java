package com.blog.core.category.service.impl;


import com.blog.core.category.dao.ManageCategoryMapper;
import com.blog.core.category.dto.ManageCategoryAddDTO;
import com.blog.core.category.dto.ManageCategoryEditDTO;
import com.blog.core.category.dto.ManageCategoryIdDTO;
import com.blog.core.category.entity.ManageCategory;
import com.blog.core.category.service.ManageCategoryService;
import com.blog.core.category.vo.ManageCategoryVO;
import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description: 文章分类信息service
 * @author: 950103
 * @create: 2019-11-22 17:54
 * @Version: 1.0
 */
@Service("manageCategoryService")
public class ManageCategoryServiceImpl implements ManageCategoryService {

    @Autowired
    private ManageCategoryMapper manageCategoryMapper;

    @Override
    public List<ManageCategoryVO> queryManageCategoryByPage() {
        List<ManageCategoryVO> manageCategoryVOList = this.manageCategoryMapper.selectManageCategoryByPage();
        return manageCategoryVOList;
    }


    @Override
    public ManageCategoryVO queryManageCategoryByCategoryId(String categoryId) {
        ManageCategoryVO manageCategoryVO = this.manageCategoryMapper.selectManageCategoryByCategoryId(categoryId);
        return manageCategoryVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addManageCategory(ManageCategoryAddDTO manageCategoryAddDTO) {
        ManageCategory manageCategory = MapperUtils.mapperBean(manageCategoryAddDTO, ManageCategory.class);
        SecurityUser currentUser = SecurityUtils.getUser();
        manageCategory.setCreateId(currentUser.getUserId());
        manageCategory.setCreateTime(new Date());
        manageCategory.setEnable(EnableEnum.Enable_YES);
        this.manageCategoryMapper.insertManageCategory(manageCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editManageCategory(ManageCategoryEditDTO manageCategoryEditDTO){
        ManageCategory manageCategory = MapperUtils.mapperBean(manageCategoryEditDTO, ManageCategory.class);
        SecurityUser currentUser = SecurityUtils.getUser();
        manageCategory.setUpdateId(currentUser.getUserId());
        manageCategory.setUpdateTime(new Date());
        this.manageCategoryMapper.updateManageCategory(manageCategory);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enableManageCategoryByCategoryId(ManageCategoryIdDTO manageCategoryIdDTO) {
        this.manageCategoryMapper.enableManageCategoryByCategoryId(manageCategoryIdDTO.getCategoryIdList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disableManageCategoryByCategoryId(ManageCategoryIdDTO manageCategoryIdDTO) {
        this.manageCategoryMapper.disableManageCategoryByCategoryId(manageCategoryIdDTO.getCategoryIdList());
    }
}
