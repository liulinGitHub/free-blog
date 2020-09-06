package com.blog.core.system.user.service;

import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import com.blog.core.system.user.dto.ManageUserLoginInfoEditDTO;
import com.blog.core.system.user.vo.ManageUserDetailVO;
import com.blog.core.system.user.vo.ManageUserListVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;

import java.util.List;

/**
 * @description: 用户信息service
 * @author: 950103
 * @create_time: 2019/11/24 1:10
 * @version: 1.0
 **/
public interface ManageUserService {

    /**
     * 分页查询用户信息
     *
     * @return
     */
    List<ManageUserListVO> queryManageUserByPage();

    /**
     * 根据用户id查看用户详情
     *
     * @param userId
     * @return
     */
    ManageUserDetailVO queryManageUserDetails(Integer userId);

    /**
     * 根据用户名查询登录用户信息
     *
     * @Param userName
     * @return
     **/
    ManageUserLoginVO queryUserByUserName(String userName);

    /**
     * 添加用户信息
     *
     * @param manageUserAddDTO
     */
    void addManageUser(ManageUserAddDTO manageUserAddDTO);

    /**
     * 修改用户信息
     *
     * @param manageUserEditDTO
     */
    void editManageUser(ManageUserEditDTO manageUserEditDTO);

    /**
     * 修改用户登录相关信息
     *
     * @param manageUserLoginInfoEditDTO
     */
    void editManageUserLoginInfo(ManageUserLoginInfoEditDTO manageUserLoginInfoEditDTO);

    /**
     * 禁用用户
     *
     * @param userId
     */
    void disableUserByUserId(Integer userId);

    /**
     * 启用用户
     *
     * @param userId
     */
    void enableUserByUserId(Integer userId);
}
