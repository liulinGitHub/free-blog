package com.blog.core.system.user.dao;

import com.blog.core.system.user.entity.User;
import com.blog.core.system.user.vo.UserDetailVO;
import com.blog.core.system.user.vo.UserListVO;
import com.blog.core.system.user.vo.UserLoginVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 用户信息Mapper
 * @author: 950103
 * @create_time: 2019/11/24 1:16
 * @version: 1.0
 **/
@Repository("userMapper")
public interface UserMapper {

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
    UserDetailVO selectUserByUserId(Integer userId);

    /**
     * 根据用户名查询登录用户信息
     *
     * @Param userName
     * @return
     **/
    UserLoginVO selectUserByUserName(String userName);

    /**
     * 添加用户信息
     *
     * @param User
     */
    void insertUser(User User);

    /**
     * 修改用户信息
     *
     * @param User
     */
    void updateUser(User user);

    /**
     * 修改用户登录相关信息
     *
     * @param User
     */
    void updateUserLoginInfo(User user);

    /**
     * 禁用用户
     *
     * @param User
     */
    void disableUserByUserId(User user);

    /**
     * 启用用户
     *
     * @param User
     */
    void enableUserByUserId(User user);
}
