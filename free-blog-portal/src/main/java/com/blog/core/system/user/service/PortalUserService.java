package com.blog.core.system.user.service;


import com.blog.core.system.user.dto.PortalUserAddDTO;
import com.blog.core.system.user.dto.PortalUserEditDTO;
import com.blog.core.system.user.dto.PortalUserLoginDTO;
import com.blog.core.system.user.dto.PortalUserQueryDTO;
import com.blog.core.system.user.vo.PortalUserInfoVO;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import com.blog.core.system.user.vo.PortalUserVO;
import java.util.List;

/**
 * @ClassName: PortalUserService
 * @Description: 公共service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
public interface PortalUserService {

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    PortalUserInfoVO queryUserInfo(String userId);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     */
    PortalUserLoginVO queryUserByUserName(String username);

    /**
     * 查询用户信息
     *
     * @param UserQueryDTO
     * @return
     */
    List<PortalUserVO> queryPortalUser(PortalUserQueryDTO UserQueryDTO);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     */
    PortalUserVO queryPortalUserDetails(String userId);

    /**
     * 添加用户信息
     *
     * @param UserAddDTO
     */
    void savePortalUser(PortalUserAddDTO UserAddDTO);

    /**
     * 修改用户信息
     *
     * @return
     */
    void editPortalUser(PortalUserEditDTO UserEditDTO);


}
