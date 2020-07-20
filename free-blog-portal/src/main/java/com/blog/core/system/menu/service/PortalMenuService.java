package com.blog.core.system.menu.service;


import com.blog.core.system.menu.vo.PortalMenuTree;
import com.blog.core.system.menu.vo.PortalMenuVO;

import java.util.List;

/**
 * @ClassName: PortalMenuService
 * @description: 菜单service
 * @author: 950103
 * @create: 2019-10-30 16:03
 * @Version: 1.0
 */
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
