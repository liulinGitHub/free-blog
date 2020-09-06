package com.blog.core.system.role.dao;

import com.blog.core.system.role.entity.ManageUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/4/1 12:31
 * @version: 1.0
 **/
@Repository("manageUserRoleMapper")
public interface ManageUserRoleMapper {

    void deleteUserRoleByUserId(Integer userId);

    void insertManageUserRole(@Param("manageUserRoleList") List<ManageUserRole> manageUserRoleList);

}
