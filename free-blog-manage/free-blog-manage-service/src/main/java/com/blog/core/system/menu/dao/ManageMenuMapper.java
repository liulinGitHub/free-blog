package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.ManageMenu;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/2/7 16:26
 * @version: 1.0
 **/
@Repository("manageMenuMapper")
public interface ManageMenuMapper {


    List<ManageMenuListVO> selectManageMenuAll();

    /**
     * 查询全部菜单信息
     *
     * @return
     **/
    List<ManageMenuListVO> selectBuildManageMenuList();

    /**
     * 根据用户id查询菜单
     *
     * @Param userId
     * @return
     **/
    List<ManageMenuListVO> selectBuildManageMenuByUserId(Integer userId);

    ManageMenuVO selectManageMenuByMenuId(Integer menuId);

    void insertManageMenu(ManageMenu manageMenu);

    void updateManageMenu(ManageMenu manageMenu);

    void disableManageMenuByByMenuId(Integer menuId);

    void enableManageMenuByMenuId(Integer menuId);
}
