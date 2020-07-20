package com.blog.core.system.role.dao;


import com.blog.core.system.role.entity.PortalRole;
import com.blog.core.system.role.entity.PortalUserRole;
import com.blog.core.system.role.vo.PortalRoleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName: PortalRoleMapper
 * @description:
 * @author: 950103
 * @create: 2019-10-09 18:02
 * @Version: 1.0
 */
@Repository("portalRoleMapper")
public interface PortalRoleMapper {

    /**
     * 查询所有角色信息
     * @return
     */
    List<PortalRoleVO> selectPortalRole();

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
     * @param userId
     * @return
     */
    List<PortalRoleVO> selectRoleByUserId(@Param("userId") String userId);

    /**
     * 根据请求的URL查询所属的角色信息
     * @param url
     */
    List<PortalRoleVO> selectRoleByUrl(String url);
}
