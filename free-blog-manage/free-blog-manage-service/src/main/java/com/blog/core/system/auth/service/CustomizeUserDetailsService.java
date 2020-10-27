package com.blog.core.system.auth.service;

import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.role.service.RoleService;
import com.blog.core.system.user.service.UserService;
import com.blog.core.system.user.vo.UserLoginVO;
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
 * @description: 自定义用户详情
 * @author: 950103
 * @create_time: 2019/10/26 1:31
 * @version: 1.0
 **/
@Slf4j
@Service
public class CustomizeUserDetailsService implements UserDetailsService {

    @Resource
    private UserService UserService;

    @Resource
    private RoleService RoleService;

    /**
     * 获取用户信息  返回UserDetails对象
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLoginVO userLoginVO = this.UserService.queryUserByUserName(username);
        if(Objects.isNull(userLoginVO)){
            throw new BlogRuntimeException("用户名不正确！");
        }
        if(EnableEnum.Enable_NO.getValue().equals(userLoginVO.getUserId())) {
            throw new BlogRuntimeException("账号未激活！");
        }
        return createSecurityUserDetailsUser(userLoginVO);
    }

    private SecurityUser createSecurityUserDetailsUser(UserLoginVO userLoginVO) {
        Collection<GrantedAuthority> authorities = this.RoleService.queryRoleInfoByUserId(userLoginVO.getUserId());
        return new SecurityUser(userLoginVO.getUserId(),
                userLoginVO.getUsername(),
                userLoginVO.getPassword(),
                userLoginVO.getGender(),
                userLoginVO.getNickName(),
                userLoginVO.getAvatar(),
                userLoginVO.getTelephone(),
                userLoginVO.getEmail(),
                authorities);
    }
}
