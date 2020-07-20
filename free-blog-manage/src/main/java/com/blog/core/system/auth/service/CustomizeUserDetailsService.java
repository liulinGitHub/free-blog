package com.blog.core.system.auth.service;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.role.service.ManageRoleService;
import com.blog.core.system.user.service.ManageUserService;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Objects;

/**
 * @ClassNmae: UserDetailsService
 * @description: 自定义用户详情
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

        if(Objects.isNull(manageUserLoginVO)){
            throw new BlogRuntimeException("用户名不正确！");
        }
        if(EnableEnum.Enable_NO.getValue().equals(manageUserLoginVO.getUserId())) {
            throw new BlogRuntimeException("账号未激活！");
        }
        return createSecurityUserDetailsUser(manageUserLoginVO);
    }

    private SecurityUser createSecurityUserDetailsUser(ManageUserLoginVO manageUserLoginVO) {
        Collection<GrantedAuthority> authorities = this.manageRoleService.queryRoleInfoByUserId(manageUserLoginVO.getUserId());
        return new SecurityUser(manageUserLoginVO.getUserId(),
                manageUserLoginVO.getUsername(),
                manageUserLoginVO.getPassword(),
                manageUserLoginVO.getSex(),
                manageUserLoginVO.getNickName(),
                manageUserLoginVO.getAvatar(),
                manageUserLoginVO.getTelephone(),
                manageUserLoginVO.getEmail(),
                authorities);
    }
}
