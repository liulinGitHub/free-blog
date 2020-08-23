package com.blog.core.system.user.dao;

import com.blog.core.system.user.vo.PortalUserInfoVO;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: PortalUserMapper
 * @description: 用户Mapper
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
    PortalUserInfoVO selectUserByUserName(String userName);

    /**
     * 根据用户id查询用户信息
     *
     * @param userId
     * @return
     */
    PortalUserInfoVO selectUserInfoByUserId(String userId);
}
