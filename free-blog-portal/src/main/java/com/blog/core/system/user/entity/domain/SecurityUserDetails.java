package com.blog.core.system.user.entity.domain;

import com.blog.core.common.consts.Constants;
import com.blog.core.system.role.entity.vo.PortalRoleMenuInfoVO;
import com.blog.core.system.user.entity.vo.PortalUserLoginVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassNmae: SecurityUserDetails
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:38
 **/
public class SecurityUserDetails implements UserDetails {

    private PortalUserLoginVO portalUserLoginVO;

    private List<PortalRoleMenuInfoVO> portalRoleMenuInfoVOList;

    public SecurityUserDetails(PortalUserLoginVO portalUserLoginVO, List<PortalRoleMenuInfoVO> portalRoleMenuInfoVOList) {
        this.portalUserLoginVO = portalUserLoginVO;
        this.portalRoleMenuInfoVOList = portalRoleMenuInfoVOList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        portalRoleMenuInfoVOList.parallelStream().forEach(portalRoleMenuInfoVO -> {
            authorities.add(new SimpleGrantedAuthority(portalRoleMenuInfoVO.getRoleCode()));
        });
        //authorities.add(new SimpleGrantedAuthority(Constants.BASE_ROLE));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.portalUserLoginVO.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.portalUserLoginVO.getUserName();
    }

    /**
     * 账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否禁用
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否启用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
