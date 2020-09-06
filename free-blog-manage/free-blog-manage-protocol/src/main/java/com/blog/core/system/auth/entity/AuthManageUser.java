package com.blog.core.system.auth.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description: 用户登陆参数
 * @Author: 950103
 * @Date: 2020/3/3 15:54
 **/
@Data
public class AuthManageUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
