package com.blog.core.category.service;

import com.blog.core.category.dto.ManageCategoryAddDTO;
import com.blog.core.category.dto.ManageCategoryEditDTO;
import com.blog.core.category.dto.ManageCategoryIdDTO;
import com.blog.core.category.vo.ManageCategoryVO;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create: 2019-11-22 17:53
 * @Version: 1.0
 */
public interface ManageCategoryService {

    /**
     * @Author ll
     * @Description 分页查询分类信息
     * @Date 2020/2/9 21:43
     * @Param []
     * @return java.util.List<com.blog.core.category.vo.ManageCategoryVO>
     **/
    List<ManageCategoryVO> queryManageCategoryByPage();

    /**
     * @Author ll
     * @Description 查看分类详情
     * @Date 2020/2/9 21:43
     * @Param [categoryId]
     * @return com.blog.core.category.vo.ManageCategoryVO
     **/
    ManageCategoryVO queryManageCategoryByCategoryId(String categoryId);

    /**
     * @Author ll
     * @Description 添加分类信息
     * @Date 2020/2/9 21:42
     * @Param [manageCategoryAddDTO]
     * @return void
     **/
    void addManageCategory(ManageCategoryAddDTO manageCategoryAddDTO);

    /**
     * @Author ll
     * @Description 修改分类信息
     * @Date 2020/2/9 21:42
     * @Param [manageCategoryEditDTO]
     * @return void
     **/
    void editManageCategory(ManageCategoryEditDTO manageCategoryEditDTO);

    /**
     * @Author ll
     * @Description 启用分类信息
     * @Date 2020/2/9 21:42
     * @Param [manageCategoryIdDTO]
     * @return void
     **/
    void enableManageCategoryByCategoryId(ManageCategoryIdDTO manageCategoryIdDTO);

    /**
     * @Author ll
     * @Description 停用分类信息
     * @Date 2020/2/9 21:42
     * @Param [manageCategoryIdDTO]
     * @return void
     **/
    void disableManageCategoryByCategoryId(ManageCategoryIdDTO manageCategoryIdDTO);
}
