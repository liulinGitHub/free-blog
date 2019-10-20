package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.domain.PortalRoleMenu;

/**
 * @program: PortalRoleMenuMapper
 * @description:
 * @author: liulin
 * @create: 2019-10-10 10:49
 * @Version: 1.0
 */
public interface PortalRoleMenuMapper {

    int  insertRoleMenu(PortalRoleMenu portalRoleMenu);

    int deleteRoleMenuByRoleId(String roleId);
}
