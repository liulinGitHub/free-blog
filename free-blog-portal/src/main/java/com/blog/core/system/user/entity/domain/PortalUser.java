package com.blog.core.system.user.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassNmae:SysBaseUser
 * @description: 用户信息
 * @Author:liulin
 * @Date: 2019/4/7 20:09
 **/

@Data
@Api(value = "用户信息")
public class PortalUser extends BaseModel {

    @ApiModelProperty(value="用户名Id",name="userId")
    private String userId;

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="登陆密码",name="userPassword")
    private String userPassword;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

    @ApiModelProperty(value="停用/启用（0，停用；1，启用）",name="isEnable")
    private String isEnable;

    @ApiModelProperty(value="盐）",name="salt")
    private String salt;

    @ApiModelProperty(value="登陆ip",name="lastLoginIp")
    private String lastLoginIp;

    @ApiModelProperty(value="上一次登陆时间",name="lastLoginTime")
    private Date lastLoginTime;

    @ApiModelProperty(value="个性签名",name="signature")
    private String signature;

    @ApiModelProperty(value="发布评论数",name="comments")
    private Long comments;

    @ApiModelProperty(value="文章数",name="posts")
    private Long articleTotal;

    @ApiModelProperty(value="性别",name="gender")
    private String gender;

    @ApiModelProperty(value="关注的用户id",name="attentionId")
    private String attentionId;
}
