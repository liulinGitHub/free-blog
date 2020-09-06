package com.blog.core.system.role.dao;

import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: 950103
 * @create_time: 2020/3/9 15:08
 * @version: 1.0
 **/
@Repository("manageRoleMapper")
public interface ManageRoleMapper {


    List<ManageRoleListVO> selectManageRoleByPage();

    List<ManageRoleInfoVO> selectUserRoleByUserId(Integer userId);

    List<ManageRoleInfoVO> selectRoleInfoByUserId(Integer userId);
}
