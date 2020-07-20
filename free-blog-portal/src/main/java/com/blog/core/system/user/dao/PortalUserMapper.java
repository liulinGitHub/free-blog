package com.blog.core.system.user.dao;

import com.blog.core.system.user.dto.PortalUserLoginDTO;
import com.blog.core.system.user.dto.PortalUserQueryDTO;
import com.blog.core.system.user.entity.PortalUser;
import com.blog.core.system.user.vo.PortalUserInfoVO;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import com.blog.core.system.user.vo.PortalUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: PortalUserMapper
 * @description:
 * @author: 950103
 * @create: 2019-10-09 17:50
 * @Version: 1.0
 */
@Repository("portalUserMapper")
public interface PortalUserMapper {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    PortalUserLoginVO selectUserByUserName(String userName);

    /**
     * 根据用户名查询用户信息
     * @param userId
     * @return
     */
    PortalUserInfoVO selectUserInfo(String userId);

    /**
     * 用户登录
     * @param portalUserLoginDTO
     * @return
     */
    PortalUserLoginVO login(PortalUserLoginDTO portalUserLoginDTO);

    /**
     * 查询用户信息
     * @param portalUserQueryDTO
     * @return
     */
    List<PortalUserVO> queryUser(PortalUserQueryDTO portalUserQueryDTO);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    PortalUserVO selectUserById(@Param(value = "userId") String userId);

    /**
     * 添加用户信息
     * @param User
     * @return
     */
    int insertUser(PortalUser User);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(PortalUser user);

    /**
     * 修改用户启用/停用状态
     * @return
     */
    int updateIsEnable(PortalUser user);

    /**
     * 根据用户id增加一次用户的文章数
     * @param articleUserId
     * @return
     */
    int updateArticleTotal(String articleUserId);

    int insertSelective(@Param("pojo") PortalUser pojo);

    int insertList(@Param("pojos") List<PortalUser> pojo);
}
