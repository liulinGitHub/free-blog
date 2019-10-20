package com.blog.core.system.user.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: SysBaseUserQueryDTO
 * @description: 登陆传参对象
 * @Author: liulin
 * @Date: 2019/4/14 23:46
 **/
@Data
public class PortalUserLoginDTO {

    @ApiModelProperty(value="登陆用户名",name="username")
    private String username;

    @ApiModelProperty(value="登陆密码",name="userpassword")
    private String userpassword;
}
