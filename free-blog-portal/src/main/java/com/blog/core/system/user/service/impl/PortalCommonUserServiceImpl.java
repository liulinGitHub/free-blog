package com.blog.core.system.user.service.impl;

import com.blog.core.attentioninfo.vo.AttentionUserVO;
import com.blog.core.system.user.dao.PortalCommonUserMapper;
import com.blog.core.system.user.entity.PortalCommonUser;
import com.blog.core.system.user.service.PortalCommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: PortalCommonUserServiceImpl
 * @Description: 用户公共调用service
 * @date: 2020/7/19 0:13
 * @author: 950103
 * @Version 1.0
 */
@Service
public class PortalCommonUserServiceImpl implements PortalCommonUserService {

    @Autowired
    private PortalCommonUserMapper portalCommonUserMapper;

    @Override
    public PortalCommonUser queryPortalCommonUserByUserId(Integer userId) {
        return this.portalCommonUserMapper.selectPortalCommonUserByUserId(userId);
    }

    @Override
    public List<AttentionUserVO> queryPortalAttentionUserInfo(List<Integer> userIdList) {
        return this.portalCommonUserMapper.selectPortalAttentionUserInfo(userIdList);
    }
}
