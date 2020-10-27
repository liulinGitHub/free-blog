package com.blog.core.system.role.service;

import com.blog.core.system.role.vo.RoleListVO;

import java.util.List;

/**
 * @description: 用户角色关联service
 * @author: 950103
 * @create_time: 2020/4/1 12:14
 * @version: 1.0
 **/
public interface UserRoleService {

    /**
     * 添加用户和角色关联
     *
     * @param userId
     * @param roleIdList
     */
    void addUserRoleRelevance(Integer userId, List<Integer> roleIdList);
}
