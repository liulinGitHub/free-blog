package com.blog.core.system.role.service;

import java.util.List;

/**
 * @ClassNmae: ManageUserRoleService
 * @description: 用户角色关联service
 * @Author: liulin
 * @Date: 2020/4/1 12:14
 **/
public interface ManageUserRoleService {

    /**
     * 添加用户和角色关联
     *
     * @param userId
     * @param roleIdList
     */
    void addUserRoleRelevance(String userId, List<String> roleIdList);
}
