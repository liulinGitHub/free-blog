package com.blog.core.system.role.service.impl;

import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.role.dao.ManageUserRoleMapper;
import com.blog.core.system.role.entity.ManageUserRole;
import com.blog.core.system.role.service.ManageUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户角色关联service
 * @author: 950103
 * @create_time: 2020/4/1 12:16
 * @version: 1.0
 **/
@Service
public class ManageUserRoleServiceImpl implements ManageUserRoleService {

    @Autowired
    private ManageUserRoleMapper manageUserRoleMapper;

    @Transactional
    @Override
    public void addUserRoleRelevance(Integer userId, List<Integer> roleIdList) {
        SecurityUser currentUser = SecurityUtils.getUser();
        //删除用户的所有角色
        this.manageUserRoleMapper.deleteUserRoleByUserId(userId);
        //添加用户和角色关联
        List<ManageUserRole> manageUserRoleList = new ArrayList<>();
        for (Integer roleId : roleIdList) {
            ManageUserRole manageUserRole = new ManageUserRole();
            manageUserRole.setUserId(userId);
            manageUserRole.setRoleId(roleId);
            manageUserRole.setCreateId(currentUser.getUserId());
            manageUserRole.setCreateTime(new Date());
            manageUserRoleList.add(manageUserRole);
        }
        this.manageUserRoleMapper.insertManageUserRole(manageUserRoleList);
    }
}
