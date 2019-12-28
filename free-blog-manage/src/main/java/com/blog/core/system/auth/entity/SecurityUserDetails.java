package com.blog.core.system.auth.entity;

import com.blog.core.system.role.vo.ManageRoleMenuInfoVO;
import com.blog.core.system.user.vo.ManageUserLoginVO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @program: SecurityUserDetails
 * @description:
 * @author: liulin
 * @create: 2019-12-27 13:34
 * @Version: 1.0
 */
@Data
public class SecurityUserDetails implements UserDetails {

    private ManageUserLoginVO manageUserLoginVO;

    private List<ManageRoleMenuInfoVO> manageRoleMenuInfoVOList;

    public SecurityUserDetails(ManageUserLoginVO manageUserLoginVO, List<ManageRoleMenuInfoVO> manageRoleMenuInfoVOList){
        this.manageUserLoginVO = manageUserLoginVO;
        this.manageRoleMenuInfoVOList = manageRoleMenuInfoVOList;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.manageUserLoginVO.getUserPassword();
    }

    @Override
    public String getUsername() {
        return this.manageUserLoginVO.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
