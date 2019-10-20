package com.blog.core.system.role.service;

import com.blog.core.system.role.entity.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.entity.vo.PortalRoleVO;

import java.util.List;

public interface PortalRoleService {

    /**
     * 保存用户角色信息
     * @param portalUserRoleAddQO
     */
    void addUserRole(PortalUserRoleAddQO portalUserRoleAddQO);

    /**
     * 根据用户id查询角色
     * @param UserId
     * @return
     */
    List<PortalRoleVO> queryRoleByUserId(String UserId);
}
