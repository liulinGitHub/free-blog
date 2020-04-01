package com.blog.core.system.role.dao;

import com.blog.core.system.role.entity.ManageUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageUserRoleMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/4/1 12:31
 **/
@Repository("manageUserRoleMapper")
public interface ManageUserRoleMapper {

    void deleteUserRoleByUserId(String userId);

    void insertManageUserRole(@Param("manageUserRoleList") List<ManageUserRole> manageUserRoleList);

}
