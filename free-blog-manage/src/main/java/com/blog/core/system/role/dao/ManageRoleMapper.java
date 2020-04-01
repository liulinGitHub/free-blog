package com.blog.core.system.role.dao;

import com.blog.core.system.role.vo.ManageRoleInfoVO;
import com.blog.core.system.role.vo.ManageRoleListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageRoleMapper
 * @description:
 * @Author: liulin
 * @Date: 2020/3/9 15:08
 **/
@Repository("manageRoleMapper")
public interface ManageRoleMapper {


    List<ManageRoleListVO> selectManageRoleByPage();

    List<ManageRoleInfoVO> selectRoleInfoByUserId(String userId);
}
