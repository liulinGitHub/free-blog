package com.blog.core.system.menu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.common.enums.MenuTypeEnum;
import com.blog.core.system.menu.dto.ManageMenuAddDTO;
import com.blog.core.system.menu.dto.ManageMenuEditDTO;
import com.blog.core.system.menu.entity.ManageMenuTree;
import com.blog.core.system.menu.service.ManageMenuService;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageMenuServiceImplTest {

    @Autowired
    private ManageMenuService manageMenuService;

    @Test
    public void buildMenus() {
        List<ManageMenuListVO> manageMenuListVOS = this.manageMenuService.queryBuildManageMenu();
        List<ManageMenuListVO> manageMenuListVOList = this.manageMenuService.buildMenuTree(manageMenuListVOS);
        List<ManageMenuTree> manageMenuTreeList = manageMenuService.buildMenus(manageMenuListVOList);
        System.out.println(JSONObject.toJSONString(manageMenuTreeList));
    }

    @Test
    public void queryManageMenuByMenuId() {
        String menuId = "20200108220000000000000000000002";
        ManageMenuVO manageMenuVO = this.manageMenuService.queryManageMenuByMenuId(menuId);
        System.out.println(manageMenuVO);
    }

    @Test
    public void addManageMenu() {
        ManageMenuAddDTO manageMenuAddDTO = new ManageMenuAddDTO();
        manageMenuAddDTO.setMenuName("测试菜单");
        manageMenuAddDTO.setWebCode("ceshi");
        manageMenuAddDTO.setMenuUrl("www.ceshi.com");
        manageMenuAddDTO.setIcon("add");
        manageMenuAddDTO.setMenuSort(1);
        manageMenuAddDTO.setMenuType(MenuTypeEnum.MENU);

        this.manageMenuService.addManageMenu(manageMenuAddDTO);
    }

    @Test
    public void editManageMenu() {
        ManageMenuEditDTO manageMenuEditDTO = new ManageMenuEditDTO();
        manageMenuEditDTO.setMenuId("20200108220000000000000000000002");
        manageMenuEditDTO.setMenuName("测试菜单1");
        manageMenuEditDTO.setWebCode("ceshi1");
        manageMenuEditDTO.setMenuUrl("www.ceshi1.com");
        manageMenuEditDTO.setIcon("edit");
        manageMenuEditDTO.setMenuSort(2);
        manageMenuEditDTO.setMenuType(MenuTypeEnum.BUTTON);

        this.manageMenuService.editManageMenu(manageMenuEditDTO);
    }

    @Test
    public void disableManageMenuByByMenuId() {
        String menuId = "20200108220000000000000000000002";
        this.manageMenuService.disableManageMenuByByMenuId(menuId);
    }

    @Test
    public void enableManageMenuByMenuId() {
        String menuId = "20200108220000000000000000000002";
        this.manageMenuService.enableManageMenuByMenuId(menuId);
    }
}
