package com.blog.core.system.menu.service;

import com.blog.core.system.menu.dto.ManageMenuAddDTO;
import com.blog.core.system.menu.dto.ManageMenuEditDTO;
import com.blog.core.system.menu.entity.ManageMenuTree;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuVO;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/2/7 16:20
 * @version: 1.0
 **/
public interface ManageMenuService {

    /**
     * 查询全部的菜单
     *
     * @return
     */
    List<ManageMenuListVO> queryManageMenuAll();

    /**
     * 查询前端所需要的菜单
     *
     * @return
     */
    List<ManageMenuListVO> queryBuildManageMenu();


    List<ManageMenuTree> buildMenus(List<ManageMenuListVO> manageMenuListVOList);

    /**
     * @Author ll
     * @Description 根据登录用户获取相应的菜单
     * @Date 2020/2/8 20:17
     * @Param []
     * @return java.util.List<com.blog.core.system.menu.entity.ManageMenuTree>
     **/
    List<ManageMenuListVO> buildMenuTree(List<ManageMenuListVO> manageMenuListVOList);

    /**
     * @Author ll
     * @Description 查看菜单详情
     * @Date 2020/2/8 20:17
     * @Param [menuId]
     * @return com.blog.core.system.menu.vo.ManageMenuVO
     **/
    ManageMenuVO queryManageMenuByMenuId(Integer menuId);

    /**
     * @Author ll
     * @Description 添加菜单信息
     * @Date 2020/2/8 20:18
     * @Param [manageMenuAddDTO]
     * @return void
     **/
    void addManageMenu(ManageMenuAddDTO manageMenuAddDTO);

    /**
     * @Author ll
     * @Description 修改菜单信息
     * @Date 2020/2/8 20:19
     * @Param [manageMenuEditDTO]
     * @return void
     **/
    void editManageMenu(ManageMenuEditDTO manageMenuEditDTO);

    /**
     * @Author ll
     * @Description 禁用菜单信息
     * @Date 2020/2/8 20:22
     * @Param [menuId]
     * @return void
     **/
    void disableManageMenu(Integer menuId);

    /**
     * @Author ll
     * @Description 启用菜单信息
     * @Date 2020/2/8 20:22
     * @Param [menuId]
     * @return void
     **/
    void enableManageMenu(Integer menuId);
}
