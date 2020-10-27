package com.blog.core.system.role.dao;

import com.blog.core.system.role.entity.UserRole;
import com.blog.core.system.role.vo.RoleListVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/4/1 12:31
 * @version: 1.0
 **/
@Repository("userRoleMapper")
public interface UserRoleMapper {

    void deleteUserRoleByUserId(Integer userId);

    void insertUserRole(@Param("userRoleList") List<UserRole> userRoleList);

}
