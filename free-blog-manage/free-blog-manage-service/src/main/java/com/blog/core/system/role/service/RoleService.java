package com.blog.core.system.role.service;

import com.blog.core.system.role.dto.RoleAddDTO;
import com.blog.core.system.role.dto.RoleEditDTO;
import com.blog.core.system.role.vo.RoleDetailsVO;
import com.blog.core.system.role.vo.RoleInfoVO;
import com.blog.core.system.role.vo.RoleListVO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @description: 角色service
 * @author: 950103
 * @create_time: 2019/12/22 23:25
 * @version: 1.0
 **/
public interface RoleService {

    /**
     * 分页查询角色信息
     *
     * @return
     */
    List<RoleListVO> queryRoleByPage();

    /**
     * 查询角色列表
     * 
     * @return
     */
    List<RoleListVO> queryRoleList();

    /**
     * 查询角色详情
     *
     * @param roleId
     * @return
     */
    List<RoleDetailsVO> queryRoleDetails(Integer roleId);

    /**
     * 查询用户的角色
     *
     * @param userId
     * @return
     */
    List<RoleListVO> queryUserRoleList(Integer userId);

    void addRole(RoleAddDTO RoleAddDTO);

    void editRole(RoleEditDTO RoleEditDTO);

    void disableRole(Integer roleId);

    void enableRole(Integer roleId);

    /**
     * 根据用户id查询用户角色权限
     *
     * @param userId
     * @return
     */
    Collection<GrantedAuthority> queryRoleInfoByUserId(Integer userId);
}
