package com.blog.core.system.user.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: UserCheckLoginVO
 * @description: 校验登陆用户信息
 * @Author: liulin
 * @Date: 2019/7/14 18:04
 **/
@Data
public class UserCheckLoginVO {

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="登陆密码",name="userPassword")
    private String userPassword;
}
