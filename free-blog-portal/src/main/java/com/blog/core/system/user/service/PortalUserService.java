package com.blog.core.system.user.service;

import com.blog.core.system.user.entity.dto.PortalUserAddDTO;
import com.blog.core.system.user.entity.dto.PortalUserEditDTO;
import com.blog.core.system.user.entity.dto.PortalUserLoginDTO;
import com.blog.core.system.user.entity.dto.PortalUserQueryDTO;
import com.blog.core.system.user.entity.vo.PortalUserInfoVO;
import com.blog.core.system.user.entity.vo.PortalUserLoginVO;
import com.blog.core.system.user.entity.vo.PortalUserVO;

import java.util.List;


public interface PortalUserService {

    /**
     * 查询判断用户信息是否正确
     * @param userLoginDTO
     * @return
     */
    PortalUserLoginVO checkLogin(PortalUserLoginDTO userLoginDTO);

    /**
     * 用户登录
     * @param UserLoginDTO
     * @return
     */
    PortalUserLoginVO login(PortalUserLoginDTO UserLoginDTO);

    /**
     * 根据用户名查询用户信息
     * @param userId
     * @return
     */
    PortalUserInfoVO queryUserInfo(String userId);

    /**
     * 查询用户信息
     * @param UserQueryDTO
     * @return
     */
    List<PortalUserVO> queryUser(PortalUserQueryDTO UserQueryDTO);

    /**
     * 根据用户id查询用户信息
     * @param userId
     */
    PortalUserVO queryUserById(String userId);

    /**
     * 添加用户信息
     * @param UserAddDTO
     */
    void addUser(PortalUserAddDTO UserAddDTO);

    /**
     * 修改用户信息
     * @return
     */
    void updateUser(PortalUserEditDTO UserEditDTO);


}
