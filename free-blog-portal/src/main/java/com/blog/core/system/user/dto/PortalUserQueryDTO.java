package com.blog.core.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalUserQueryDTO
 * @description: 登陆传参对象
 * @Author: 950103
 * @Date: 2019/4/14 23:46
 **/
@Data
public class PortalUserQueryDTO {

    @ApiModelProperty(value="登陆用户名",name="username")
    private String username;

    @ApiModelProperty(value="登陆密码",name="password")
    private String password;
}