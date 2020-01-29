package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageUserLoginVO
 * @description:
 * @Author: liulin
 * @Date: 2019/12/22 23:25
 **/
@Data
public class ManageUserLoginVO {

    @ApiModelProperty(value="用户id",name="username")
    private String userId;

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="登陆密码",name="userPassword")
    private String userPassword;

    @ApiModelProperty(value="盐",name="salt")
    private String salt;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @ApiModelProperty(value="token",name="token")
    private String token;
}