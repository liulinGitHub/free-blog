package com.blog.core.system.user.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: PortalUser
 * @description: 用户信息
 * @Author: 950103
 * @Date: 2019/4/7 20:09
 **/
@Data
@Api(value = "用户信息")
public class PortalUser extends BaseModel {

    @ApiModelProperty("用户名Id")
    private String userId;

    @ApiModelProperty("登陆用户名")
    private String userName;

    @ApiModelProperty("登陆密码")
    private String userPassword;

    @ApiModelProperty("盐）")
    private String salt;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("登陆ip")
    private String lastLoginIp;

    @ApiModelProperty("上一次登陆时间")
    private Date lastLoginTime;

    @ApiModelProperty("个性签名")
    private String signature;

    @ApiModelProperty("关注的用户id")
    private String attentionId;

    @ApiModelProperty("停用/启用（0，停用；1，启用）")
    private String enable;
}
