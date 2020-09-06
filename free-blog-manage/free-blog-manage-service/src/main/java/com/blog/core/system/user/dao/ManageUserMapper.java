package com.blog.core.system.user.dao;

import com.blog.core.system.user.entity.ManageUser;
import com.blog.core.system.user.vo.ManageUserDetailVO;
import com.blog.core.system.user.vo.ManageUserListVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 用户信息Mapper
 * @author: 950103
 * @create_time: 2019/11/24 1:16
 * @version: 1.0
 **/
@Repository("manageUserMapper")
public interface ManageUserMapper {

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
    ManageUserDetailVO selectUserByUserId(Integer userId);

    /**
     * 根据用户名查询登录用户信息
     *
     * @Param userName
     * @return
     **/
    ManageUserLoginVO selectUserByUserName(String userName);

    /**
     * 添加用户信息
     *
     * @param manageUser
     */
    void insertManageUser(ManageUser manageUser);

    /**
     * 修改用户信息
     *
     * @param manageUser
     */
    void updateManageUser(ManageUser manageUser);

    /**
     * 修改用户登录相关信息
     *
     * @param manageUser
     */
    void updateManageUserLoginInfo(ManageUser manageUser);

    /**
     * 禁用用户
     *
     * @param manageUser
     */
    void disableUserByUserId(ManageUser manageUser);

    /**
     * 启用用户
     *
     * @param manageUser
     */
    void enableUserByUserId(ManageUser manageUser);
}