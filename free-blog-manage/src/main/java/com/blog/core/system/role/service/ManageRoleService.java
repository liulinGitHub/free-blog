package com.blog.core.system.role.service;

import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @ClassNmae: ManageRoleService
 * @description: 角色service
 * @Author: liulin
 * @Date: 2019/12/22 23:25
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
    List<ManageRoleInfoVO> queryRoleMenuInfoByUserId(String userId);

    Collection<GrantedAuthority> queryRoleInfoByUserId(String userId);
}
