package com.blog.core.system.menu.dao;

import com.blog.core.system.menu.vo.PortalMenuVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: PortalMenuMapper
 * @description:
 * @author: 950103
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
