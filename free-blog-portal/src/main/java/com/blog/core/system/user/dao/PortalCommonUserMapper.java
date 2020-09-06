package com.blog.core.system.user.dao;

import com.blog.core.attentioninfo.vo.AttentionUserVO;
import com.blog.core.system.user.entity.PortalCommonUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    PortalCommonUser selectPortalCommonUserByUserId(Integer userId);

    /**
     * 根据用户ID查询关注(被关注)的用户信息
     *
     * @param userIdList
     * @return
     */
    List<AttentionUserVO> selectPortalAttentionUserInfo(@Param("userIdList") List<Integer> userIdList);
}
