package com.blog.core.system.user.service;

import com.blog.core.system.user.dto.UserAddDTO;
import com.blog.core.system.user.dto.UserEditDTO;
import com.blog.core.system.user.dto.UserLoginInfoEditDTO;
import com.blog.core.system.user.vo.UserDetailVO;
import com.blog.core.system.user.vo.UserListVO;
import com.blog.core.system.user.vo.UserLoginVO;

import java.util.List;

/**
 * @description: 用户信息service
 * @author: 950103
 * @create_time: 2019/11/24 1:10
 * @version: 1.0
 **/
public interface UserService {

    /**
     * 分页查询用户信息
     *
     * @return
     */
    List<UserListVO> queryUserByPage();

    /**
     * 根据用户id查看用户详情
     *
     * @param userId
     * @return
     */
    UserDetailVO queryUserDetails(Integer userId);

    /**
     * 根据用户名查询登录用户信息
     *
     * @Param userName
     * @return
     **/
    UserLoginVO queryUserByUserName(String userName);

    /**
     * 添加用户信息
     *
     * @param userAddDTO
     */
    void addUser(UserAddDTO userAddDTO);

    /**
     * 修改用户信息
     *
     * @param userEditDTO
     */
    void editUser(UserEditDTO userEditDTO);

    /**
     * 修改用户登录相关信息
     *
     * @param userLoginInfoEditDTO
     */
    void editUserLoginInfo(UserLoginInfoEditDTO userLoginInfoEditDTO);

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
