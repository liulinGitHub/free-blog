package com.blog.core.system.role.dao;

import com.blog.core.system.role.entity.domain.PortalRole;
import com.blog.core.system.role.entity.domain.PortalUserRole;
import com.blog.core.system.role.entity.vo.PortalRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: PortalRoleMapper
 * @description:
 * @author: liulin
 * @create: 2019-10-09 18:02
 * @Version: 1.0
 */
@Repository("portalRoleMapper")
public interface PortalRoleMapper {

    /**
     * 分页查询角色信息
     * @return
     */
    List<PortalRoleVO> selectRoleByPage();

    /**
     * 根据id获取角色信息
     * @param roleId
     * @return
     */
    PortalRoleVO selectRoleByRoleId(String roleId);

    /**
     * 添加角色信息
     * @param role
     */
    int addRole(PortalRole role);

    /**
     * 修改角色信息
     * @param role
     * @return
     */
    int editRole(PortalRole role);

    /**
     * 删除角色信息
     * @param roleId
     * @return
     */
    int deleteRole(String roleId);

    /**
     * 启用角色信息
     * @param roleId
     * @return
     */
    int enableRole(String roleId);

    /**
     * 停用角色信息
     * @param roleId
     * @return
     */
    int disabledRole(String roleId);

    /**
     * 保存用户角色信息
     * @param userRole
     * @return
     */
    int addUserRole(PortalUserRole userRole);

    /**
     * 根据用户id查询角色
     * @param UserId
     * @return
     */
    List<PortalRoleVO> selectRoleByUserId(String UserId);
}
