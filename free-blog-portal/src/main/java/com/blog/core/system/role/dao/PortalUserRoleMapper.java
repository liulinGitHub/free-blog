package com.blog.core.system.role.dao;

import com.blog.core.system.role.entity.domain.PortalUserRole;

/**
 * @program: PortalUserRoleMapper
 * @description:
 * @author: liulin
 * @create: 2019-10-10 10:51
 * @Version: 1.0
 */
public interface PortalUserRoleMapper {

    PortalUserRole selectUserRoleByUserId(String userId);

    int insertUserRole(PortalUserRole portalUserRole);

    int deleteUserRoleByUserId(String userId);
}
