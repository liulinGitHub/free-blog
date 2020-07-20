package com.blog.core.system.user.service;

import com.blog.core.system.role.service.PortalRoleService;
import com.blog.core.system.role.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.user.vo.PortalUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CustomizeUserDetailsService
 * @Description: 公共service
 * @date: 2020/7/19 0:10
 * @author: 950103
 * @Version 1.0
 */
@Slf4j
@Service
public class CustomizeUserDetailsService implements UserDetailsService {

    @Resource
    private PortalUserService portalUserService;

    @Resource
    private PortalRoleService portalRoleService;

    /**
     * 获取用户信息
     * 返回UserDetails对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PortalUserLoginVO portalUserLoginVO = this.portalUserService.queryUserByUserName(username);
        List<PortalRoleMenuInfoVO> portalRoleMenuInfoVOList = portalRoleService.queryRoleMenuInfoByUserId(portalUserLoginVO.getUserId());
        return null;
    }
}
