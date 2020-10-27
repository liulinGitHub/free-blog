package com.blog.core.system.role.service.impl;

import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.role.dao.UserRoleMapper;
import com.blog.core.system.role.entity.UserRole;
import com.blog.core.system.role.service.UserRoleService;
import com.blog.core.system.role.vo.RoleListVO;
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
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional
    @Override
    public void addUserRoleRelevance(Integer userId, List<Integer> roleIdList) {
        SecurityUser currentUser = SecurityUtils.getUser();
        //删除用户的所有角色
        this.userRoleMapper.deleteUserRoleByUserId(userId);
        //添加用户和角色关联
        List<UserRole> userRoleList = new ArrayList<>();
        for (Integer roleId : roleIdList) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRole.setCreateId(currentUser.getUserId());
            userRole.setCreateTime(new Date());
            userRoleList.add(userRole);
        }
        this.userRoleMapper.insertUserRole(userRoleList);
    }
}
