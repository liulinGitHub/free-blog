package com.blog.core.system.role.service;

import com.blog.core.system.role.dto.ManageRoleAddDTO;
import com.blog.core.system.role.dto.ManageRoleEditDTO;
import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @description: 角色service
 * @author: 950103
 * @create_time: 2019/12/22 23:25
 * @version: 1.0
 **/
public interface ManageRoleService {

    /**
     * 分页查询角色信息
     *
     * @return
     */
    List<ManageRoleListVO> queryManageRoleByPage();

    /**
     * 根据用户查询角色信息
     *
     * @param userId
     * @return
     */
    List<ManageRoleInfoVO> queryManageRoleDetails(Integer userId);

    void addManageRole(ManageRoleAddDTO manageRoleAddDTO);

    void editManageRole(ManageRoleEditDTO manageRoleEditDTO);

    void disableManageRole(Integer roleId);

    void enableManageRole(Integer roleId);

    /**
     * 根据用户id查询用户角色权限
     *
     * @param userId
     * @return
     */
    Collection<GrantedAuthority> queryRoleInfoByUserId(Integer userId);
}
