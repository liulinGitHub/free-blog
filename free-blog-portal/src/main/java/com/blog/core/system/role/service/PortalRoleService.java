package com.blog.core.system.role.service;


import com.blog.core.system.role.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.role.vo.PortalRoleVO;

import java.util.List;

/**
 * @ClassName: PortalRoleService
 * @description: 角色信息service
 * @author: 950103
 * @create: 2019-10-30 17:44
 * @Version: 1.0
 */
public interface PortalRoleService {

    /**
     * 查询所有角色信息
     * @return
     */
    List<PortalRoleVO> queryPortalRole();

    /**
     * 保存用户角色信息
     * @param portalUserRoleAddQO
     */
    void addUserRole(PortalUserRoleAddQO portalUserRoleAddQO);

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    List<PortalRoleVO> queryRoleByUserId(String userId);

    /**
     * 根据用户id查询角色菜单
     * @param userId
     * @return
     */
    List<PortalRoleMenuInfoVO> queryRoleMenuInfoByUserId(String userId);

    /**
     * 根据请求的URL查询所属的角色信息
     * @param url
     * @return
     */
    List<PortalRoleVO> queryRoleByUrl(String url);
}
