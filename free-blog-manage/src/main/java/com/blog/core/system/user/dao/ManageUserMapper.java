package com.blog.core.system.user.dao;

import com.blog.core.system.user.entity.domain.ManageUser;
import com.blog.core.system.user.entity.vo.ManageUserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassNmae: ManageUserMapper
 * @description:
 * @Author: liulin
 * @Date: 2019/11/24 1:16
 **/
@Repository("manageUserMapper")
public interface ManageUserMapper {

    /**
     * 分页查询用户信息
     *
     * @return
     */
    List<ManageUserVO> selectArticleByPage();

    /**
     * 根据用户id查看用户详情
     *
     * @param userId
     * @return
     */
    ManageUserVO selectUserByUserId(String userId);

    /**
     * 添加用户信息
     *
     * @param manageUser
     */
    void insertUser(ManageUser manageUser);

    /**
     * 修改用户信息
     *
     * @param manageUser
     */
    void updateUser(ManageUser manageUser);

    /**
     * 禁用用户
     *
     * @param userId
     */
    void disableUserByUserId(ManageUser manageUser);

    /**
     * 启用用户
     *
     * @param userId
     */
    void enableUserByUserId(ManageUser manageUser);
}
