package com.blog.core.system.role.service;

import com.blog.core.system.role.entity.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.entity.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.role.entity.vo.PortalRoleVO;

import java.util.List;

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
     */
    List<PortalRoleVO> queryRoleByUrl(String url);
}
