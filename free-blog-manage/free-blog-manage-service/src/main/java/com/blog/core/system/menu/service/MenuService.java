package com.blog.core.system.menu.service;

import com.blog.core.system.menu.dto.MenuAddDTO;
import com.blog.core.system.menu.dto.MenuEditDTO;
import com.blog.core.system.menu.entity.MenuTree;
import com.blog.core.system.menu.vo.MenuListVO;
import com.blog.core.system.menu.vo.MenuVO;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/2/7 16:20
 * @version: 1.0
 **/
public interface MenuService {

    /**
     * 查询全部的菜单
     *
     * @return
     */
    List<MenuListVO> queryMenuAll();

    /**
     * 获取前端所需菜单
     *
     * @return
     */
    List<MenuTree> buildMenus();

    /**
     * 查看菜单详情
     *
     * @param menuId
     * @return
     */
    MenuVO queryMenuByMenuId(Integer menuId);

    /**
     * 添加菜单信息
     *
     * @param menuAddDTO
     */
    void addMenu(MenuAddDTO menuAddDTO);

    /**
     * 修改菜单信息
     *
     * @param menuEditDTO
     */
    void editMenu(MenuEditDTO menuEditDTO);

    /**
     * 禁用菜单信息
     *
     * @param menuId
     */
    void disableMenu(Integer menuId);

    /**
     * 启用菜单信息
     *
     * @param menuId
     */
    void enableMenu(Integer menuId);
}
