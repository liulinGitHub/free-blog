package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.domain.PortalRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据角色id查询所属菜单id
     * @param roleId
     * @return
     */
    List<String> selectMenuIdByRoleId(String roleId);

    /**
     * 根据角色id查询所属菜单id
     * @param roleIdList
     * @return
     */
    List<String> selectMenuIdByRoleIdList(@Param("roleIdList") List<String> roleIdList);
}
