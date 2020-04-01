package com.blog.core.category.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.blog.core.category.dto.ManageCategoryAddDTO;
import com.blog.core.category.dto.ManageCategoryEditDTO;
import com.blog.core.category.dto.ManageCategoryIdDTO;
import com.blog.core.category.service.ManageCategoryService;
import com.blog.core.category.vo.ManageCategoryVO;
import com.blog.core.common.enums.CategoryBelongTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageCategoryServiceImplTest {

    @Autowired
    private ManageCategoryService manageCategoryService;

    @Test
    public void queryManageCategoryByPage() {
        List<ManageCategoryVO> manageCategoryVOS = this.manageCategoryService.queryManageCategoryByPage();
        System.out.println(JSONObject.toJSONString(manageCategoryVOS));
    }

    @Test
    public void queryManageCategoryByCategoryId() {
        String categoryId = "20200109210000000000000000000005";
        ManageCategoryVO manageCategoryVO = this.manageCategoryService.queryManageCategoryByCategoryId(categoryId);
        System.out.println(JSONObject.toJSONString(manageCategoryVO));
    }

    @Test
    public void addManageCategory() {
        ManageCategoryAddDTO manageCategoryAddDTO = new ManageCategoryAddDTO();
        manageCategoryAddDTO.setCategoryName("测试分类");
        manageCategoryAddDTO.setSort(1);
        manageCategoryAddDTO.setParentCategoryId("123");
        manageCategoryAddDTO.setCategoryBelongType(CategoryBelongTypeEnum.ARTICLE);
        manageCategoryAddDTO.setCategoryBelongId("123");

        this.manageCategoryService.addManageCategory(manageCategoryAddDTO);
    }

    @Test
    public void editManageCategory() {
        ManageCategoryEditDTO manageCategoryEditDTO = new ManageCategoryEditDTO();
        manageCategoryEditDTO.setCategoryId("20200109210000000000000000000005");
        manageCategoryEditDTO.setCategoryName("测试分类1");
        manageCategoryEditDTO.setSort(2);
        manageCategoryEditDTO.setParentCategoryId("12345");

        this.manageCategoryService.editManageCategory(manageCategoryEditDTO);
    }

    @Test
    public void enableManageCategoryByCategoryId() {
        String categoryId = "20200109210000000000000000000005";
        List<String> list = new ArrayList<>();
        list.add(categoryId);
        ManageCategoryIdDTO manageCategoryIdDTO = new ManageCategoryIdDTO();
        manageCategoryIdDTO.setCategoryIdList(list);
        this.manageCategoryService.enableManageCategoryByCategoryId(manageCategoryIdDTO);
    }

    @Test
    public void disableManageCategoryByCategoryId() {
        String categoryId = "20200109210000000000000000000005";
        List<String> list = new ArrayList<>();
        list.add(categoryId);
        ManageCategoryIdDTO manageCategoryIdDTO = new ManageCategoryIdDTO();
        manageCategoryIdDTO.setCategoryIdList(list);
        this.manageCategoryService.disableManageCategoryByCategoryId(manageCategoryIdDTO);
    }
}
