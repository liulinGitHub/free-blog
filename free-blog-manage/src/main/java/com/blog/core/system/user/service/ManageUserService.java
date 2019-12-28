package com.blog.core.system.user.service;

import com.blog.core.system.user.entity.dto.ManageUserAddDTO;
import com.blog.core.system.user.entity.dto.ManageUserEditDTO;
import com.blog.core.system.user.entity.vo.ManageUserVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;

import java.util.List;

/**
 * @ClassNmae: ManageUserService
 * @description: 用户信息service
 * @Author: liulin
 * @Date: 2019/11/24 1:10
 **/
public interface ManageUserService {

    /**
     * 分页查询用户信息
     *
     * @return
     */
    List<ManageUserVO> queryArticleByPage();

    /**
     * 根据用户id查看用户详情
     *
     * @param userId
     * @return
     */
    ManageUserVO queryUserByUserId(String userId);

    /**
     * @Author liulin
     * @Description 根据用户名查询登录用户信息
     * @Date 2019/12/28 14:04
     * @Param [userName]
     * @return com.blog.core.system.user.vo.ManageUserLoginVO
     **/
    ManageUserLoginVO queryUserByUserName(String userName);

    /**
     * 添加用户信息
     *
     * @param manageUserAddDTO
     */
    void addUser(ManageUserAddDTO manageUserAddDTO);

    /**
     * 修改用户信息
     *
     * @param manageUserEditDTO
     */
    void editUser(ManageUserEditDTO manageUserEditDTO);

    /**
     * 禁用用户
     *
     * @param userId
     */
    void disableUserByUserId(String userId);

    /**
     * 启用用户
     *
     * @param userId
     */
    void enableUserByUserId(String userId);
}
