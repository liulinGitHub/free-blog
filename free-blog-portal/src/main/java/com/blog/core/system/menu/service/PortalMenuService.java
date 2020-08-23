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
     * 查询全部菜单
     *
     * @return
     */
    List<PortalMenuTree> queryMenuList();

    /**
     * 根据登录用户获取相应的菜单
     *
     * @return
     */
    List<PortalMenuTree> queryUserPortalMenuList();

    /**
     * 根据角色获取相应的菜单
     *
     * @param roleId
     * @return
     */
    List<PortalMenuTree> queryRoleMenu(String roleId);
}
