package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @author: 950103
 * @create_time: 2020/9/5 19:10
 * @version 1.0
 */
@Data
public class UserLoginVO {

    @ApiModelProperty(value="用户id")
    private Integer userId;

    @ApiModelProperty(value="登陆用户名")
    private String username;

    @ApiModelProperty(value="登陆密码")
    private String password;

    @ApiModelProperty(value="性别")
    private String gender;

    @ApiModelProperty(value="昵称")
    private String nickName;

    @ApiModelProperty(value="头像")
    private String avatar;

    @ApiModelProperty(value="电话号码")
    private String telephone;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="启用/停用")
    private String enable;
}
