package com.blog.core.system.auth.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: 950103
 * @create: 2019-12-27 13:34
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class SecurityUser implements UserDetails {

    @ApiModelProperty(value="用户id")
    private Integer userId;

    @ApiModelProperty(value="登陆用户名")
    private String userName;

    @ApiModelProperty(value="登陆密码")
    private String password;

    @ApiModelProperty(value="昵称")
    private String nickName;

    @ApiModelProperty(value="性别")
    private String gender;

    @ApiModelProperty(value="头像")
    private String avatar;

    @ApiModelProperty(value="电话号码")
    private String telephone;

    @ApiModelProperty(value="邮箱")
    private String email;

    private final Collection<GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return this.password;
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
