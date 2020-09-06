package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 用户详情
 * @author: 950103
 * @create_time: 2020/3/31 14:36
 * @version: 1.0
 **/
@Data
public class ManageUserDetailVO {

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("个性签名")
    private String signature;

    @ApiModelProperty("手机号")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("登陆ip")
    private String loginIp;

    @ApiModelProperty("上次登陆时间")
    private Date lastLoginTime;
}
