package com.blog.core.system.user.entity.domain;

import com.blog.core.system.user.entity.vo.PortalUserLoginVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ClassNmae: SecurityUserDetails
 * @description:
 * @Author: liulin
 * @Date: 2019/10/26 1:38
 **/
public class SecurityUserDetails implements UserDetails {

    private PortalUserLoginVO portalUserLoginVO;

    public SecurityUserDetails(PortalUserLoginVO portalUserLoginVO) {
        this.portalUserLoginVO = portalUserLoginVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
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
