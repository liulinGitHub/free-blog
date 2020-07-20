package com.blog.core.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae: PortalUserVO
 * @description: 登陆信息返回对象
 * @Author: 950103
 * @Date: 2019/4/14 19:55
 **/
@Data
public class PortalUserVO {

    @ApiModelProperty(value="用户id",name="username")
    private String id;

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="登陆密码",name="userPassword")
    private String userPassword;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="性别",name="gender")
    private String gender;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @ApiModelProperty(value="停用/启用（0，停用；1，启用）",name="isEnable")
    private String isEnable;

    @ApiModelProperty(value="登陆ip",name="lastLoginIp")
    private String lastLoginIp;

    @ApiModelProperty(value="个性签名",name="signature")
    private String signature;

    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value="是否超级管理员",name="signature")
    private String isSupper;
}
