package com.blog.core.system.role.service;

import com.blog.core.system.role.vo.ManageRoleMenuInfoVO;

import java.util.List;

/**
 * @ClassNmae: ManageRoleService
 * @description: 角色service
 * @Author: liulin
 * @Date: 2019/12/22 23:25
 **/
public interface ManageRoleService {
    
    /**
     * @Author liulin
     * @Description 根据用户id查询角色信息
     * @Date 2019/12/28 14:09
     * @Param [userId]
     * @return java.util.List<com.blog.core.system.role.vo.ManageRoleMenuInfoVO>
     **/
    List<ManageRoleMenuInfoVO> queryRoleMenuInfoByUserId(String userId);
}
