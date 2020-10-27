package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.Menu;
import com.blog.core.system.menu.vo.MenuListVO;
import com.blog.core.system.menu.vo.MenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/2/7 16:26
 * @version: 1.0
 **/
@Repository("menuMapper")
public interface MenuMapper {


    List<MenuListVO> selectMenuAll();

    /**
     * 查询全部菜单信息
     *
     * @return
     **/
    List<MenuListVO> selectBuildMenuList();

    /**
     * 根据用户id查询菜单
     *
     * @Param userId
     * @return
     **/
    List<MenuListVO> selectUserMenuByUserId(Integer userId);

    MenuVO selectMenuByMenuId(Integer menuId);

    void insertMenu(Menu menu);

    void updateMenu(Menu menu);

    void disableMenuByByMenuId(Integer menuId);

    void enableMenuByMenuId(Integer menuId);
}
