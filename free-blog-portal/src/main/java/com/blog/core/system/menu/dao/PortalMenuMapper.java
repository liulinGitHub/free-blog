package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.entity.domain.PortalMenu;
import com.blog.core.system.menu.entity.domain.PortalRoleMenu;
import com.blog.core.system.menu.entity.vo.PortalMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PortalMenuMapper
 * @description:
 * @author: liulin
 * @create: 2019-10-09 18:50
 * @Version: 1.0
 */
@Repository("portalMenuMapper")
public interface PortalMenuMapper {

    /**
     * 分页查询菜单
     * @return
     */
    List<PortalMenuVO> selectMenuByPage();

    /**
     * 根据菜单id查询菜单
     * @param menuId
     * @return
     */
    PortalMenuVO selectMenuByMenuId(String menuId);

    /**
     * 添加角色信息
     * @param portalMenu
     * @return
     */
    int addMenu(PortalMenu portalMenu);

    /**
     * 修改角色信息
     * @param portalMenu
     * @return
     */
    int editMenu(PortalMenu portalMenu);

    /**
     * 删除角色信息
     * @param menuId
     * @return
     */
    int deleteMenu(String menuId);

    /**
     * 启用角色信息
     * @param menuId
     * @return
     */
    int enableMenu(String menuId);

    /**
     * 停用角色信息
     * @param menuId
     * @return
     */
    int disabledMenu(String menuId);

    /**
     * 保存用户角色信息
     * @param userMenu
     * @return
     */
    int addRoleMenu(PortalRoleMenu userMenu);

    /**
     * 根据角色id查询菜单
     * @param roleId
     * @return
     */
    List<PortalMenuVO> selectMenuByRoleId(String roleId);

    /**
     * 查询全部菜单
     * @return
     */
    List<PortalMenuVO> selectMenuList();

    /**
     * 根据用户ID查询所属菜单
     * @param userId
     * @return
     */
    List<PortalMenuVO> selectUserMenuByUserId(String userId);
}
