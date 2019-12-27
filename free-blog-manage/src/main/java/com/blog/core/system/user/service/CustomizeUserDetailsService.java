package com.blog.core.system.user.service;

import com.blog.core.system.auth.entity.SecurityUserDetails;
import com.blog.core.system.role.entity.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.role.service.PortalRoleService;
import com.blog.core.system.role.vo.ManageRoleMenuInfoVO;
import com.blog.core.system.user.entity.domain.SecurityUserDetails;
import com.blog.core.system.user.entity.vo.PortalUserLoginVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassNmae: UserDetailsService
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:31
 **/
@Slf4j
@Service
public class CustomizeUserDetailsService implements UserDetailsService {

    @Resource
    private ManageUserService manageUserService;

    @Resource
    private ManageRoleService manageRoleService;

    /**
     * 获取用户信息
     * 返回UserDetails对象
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ManageUserLoginVO manageUserLoginVO = this.manageUserService.queryUserByUserName(username);
        List<ManageRoleMenuInfoVO> portalRoleMenuInfoVOList = this.manageRoleService.queryRoleMenuInfoByUserId(manageUserLoginVO.getUserId());
        return new SecurityUserDetails(portalUserLoginVO, portalRoleMenuInfoVOList);
    }
}
