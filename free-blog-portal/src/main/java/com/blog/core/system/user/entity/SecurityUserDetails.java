package com.blog.core.system.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @ClassNmae: SecurityUserDetails
 * @description: 用户权限扩展类
 * @Author: 950103
 * @Date: 2019/10/26 1:38
 **/
@Data
public class SecurityUserDetails implements UserDetails {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("登陆用户名")
    private String userName;

    @ApiModelProperty("登陆密码")
    private String userPassword;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    private final Collection<GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
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

    public Collection getRoles() {
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }
}
