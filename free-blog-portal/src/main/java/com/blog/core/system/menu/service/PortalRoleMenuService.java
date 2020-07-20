package com.blog.core.system.menu.service;

import java.util.List;

/**
 * @ClassName: PortalRoleMenuService
 * @description: 角色菜单service
 * @author: 950103
 * @create: 2019-10-30 16:03
 * @Version: 1.0
 */
public interface PortalRoleMenuService {

    /**
     * 根据角色id查询所属菜单id
     * @param roleId
     * @return
     */
    List<String> queryMenuIdByRoleId(String roleId);

    /**
     * 根据角色id查询所属菜单id
     * @param roleIdList
     * @return
     */
    List<String> queryMenuIdByRoleIdList(List<String> roleIdList);
}
