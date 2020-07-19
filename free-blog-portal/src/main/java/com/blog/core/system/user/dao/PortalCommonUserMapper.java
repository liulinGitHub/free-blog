package com.blog.core.system.user.dao;

import com.blog.core.system.user.entity.PortalCommonUser;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: PortalCommonUserMapper
 * @Description: 用户公共调用Mapper
 * @date: 2020/7/19 0:14
 * @author: 950103
 * @Version 1.0
 */
@Repository("portalCommonUserMapper")
public interface PortalCommonUserMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param userId
     * @return
     */
    PortalCommonUser selectPortalCommonUserByUserId(String userId);
}
