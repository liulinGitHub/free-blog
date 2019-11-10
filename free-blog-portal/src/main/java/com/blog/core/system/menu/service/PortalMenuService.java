package com.blog.core.system.menu.service;


import com.blog.core.system.menu.entity.vo.PortalMenuTree;
import com.blog.core.system.menu.entity.vo.PortalMenuVO;

import java.util.List;

public interface PortalMenuService {

    /**
     * 根据用户id查询菜单
     * @param UserId
     * @return
     */
    List<PortalMenuVO> queryMenuByUserId(String UserId);

    /**
     * 根据登录用户获取相应的菜单
     * @return
     */
    List<PortalMenuTree> queryUserMenu();

    /**
     * 查询全部菜单
     * @return
     */
    List<PortalMenuVO> queryMenuList();
}
