package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.ManageMenu;
import com.blog.core.system.menu.vo.ManageMenuListVO;
import com.blog.core.system.menu.vo.ManageMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageMenuMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/2/7 16:26
 **/
@Repository("manageMenuMapper")
public interface ManageMenuMapper {


    List<ManageMenuListVO> selectManageMenuAll();

    /**
     * @Author ll
     * @Description 查询全部菜单信息
     * @Date 2020/2/8 20:26
     * @Param []
     * @return java.util.List<com.blog.core.system.menu.vo.ManageMenuListVO>
     **/
    List<ManageMenuListVO> selectBuildManageMenuList();

    /**
     * @Author ll
     * @Description 根据用户id查询菜单
     * @Date 2020/2/8 20:26
     * @Param [userId]
     * @return java.util.List<com.blog.core.system.menu.vo.ManageMenuListVO>
     **/
    List<ManageMenuListVO> selectBuildManageMenuByUserId(String userId);

    ManageMenuVO selectManageMenuByMenuId(String menuId);

    void insertManageMenu(ManageMenu manageMenu);

    void updateManageMenu(ManageMenu manageMenu);

    void disableManageMenuByByMenuId(String menuId);

    void enableManageMenuByMenuId(String menuId);
}
