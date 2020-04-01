package com.blog.core.system.user.vo;

import com.blog.core.common.enums.IsEnableEnum;
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
    private String username;

    @ApiModelProperty(value="登陆密码",name="password")
    private String password;

    @ApiModelProperty(value="性别",name="salt")
    private String sex;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @ApiModelProperty(value="启用/停用",name="email")
    private String isEnable;
}
