package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.PortalRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: PortalRoleMenuMapper
 * @description:
 * @author: 950103
 * @create: 2019-10-10 10:49
 * @Version: 1.0
 */
public interface PortalRoleMenuMapper {

    /**
     * 根据角色id查询所属菜单id
     * @param roleId
     * @return
     */
    List<String> selectMenuIdByRoleId(String roleId);

}
