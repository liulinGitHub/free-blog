package com.blog.core.system.role.service.impl;

import com.blog.core.common.utils.PrimarykeyUtil;
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
 * @ClassNmae: ManageUserRoleServiceImpl
 * @description: 用户角色关联service
 * @Author: liulin
 * @Date: 2020/4/1 12:16
 **/
@Service
public class ManageUserRoleServiceImpl implements ManageUserRoleService {

    @Autowired
    private ManageUserRoleMapper manageUserRoleMapper;

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Transactional
    @Override
    public void addUserRoleRelevance(String userId, List<String> roleIdList) {
        SecurityUser user = SecurityUtils.getUser();
        //删除用户的所有角色
        this.manageUserRoleMapper.deleteUserRoleByUserId(userId);
        //添加用户和角色关联
        List<ManageUserRole> manageUserRoleList = new ArrayList<>();

        String pimaryKey = primarykeyUtil.getPimaryKey();
        System.out.println(pimaryKey);
        for (String roleId : roleIdList) {
            ManageUserRole manageUserRole = new ManageUserRole();
            manageUserRole.setId(primarykeyUtil.getPimaryKey());
            manageUserRole.setUserId(userId);
            manageUserRole.setRoleId(roleId);
            manageUserRole.setCreateId(user.getUserId());
            manageUserRole.setCreateTime(new Date());
            manageUserRoleList.add(manageUserRole);
        }
        this.manageUserRoleMapper.insertManageUserRole(manageUserRoleList);
    }
}
