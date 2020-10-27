package com.blog.core.system.role.dao;

import com.blog.core.system.role.vo.RoleDetailsVO;
import com.blog.core.system.role.vo.RoleInfoVO;
import com.blog.core.system.role.vo.RoleListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/3/9 15:08
 * @version: 1.0
 **/
@Repository("roleMapper")
public interface RoleMapper {

    List<RoleListVO> selectRoleByPage();

    List<RoleListVO> selectRoleList();

    List<RoleDetailsVO> selectRoleDetails(Integer roleId);

    List<RoleListVO> selectUserRoleByUserId(Integer userId);

    List<RoleInfoVO> selectRoleInfoByUserId(Integer userId);
}
