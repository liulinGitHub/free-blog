package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: UserRoleInfoVO
 * @description:
 * @author: 950103
 * @create: 2019-07-17 11:51
 * @Version: 1.0
 */
@Data
public class UserRoleInfoVO {

    @ApiModelProperty(value="用户id",name="userName")
    private String userId;

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="密码",name="userPassword")
    private String userPassword;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;

    @ApiModelProperty(value="电话号码",name="telephone")
    private String telephone;

    @ApiModelProperty(value="邮箱",name="email")
    private String email;

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

    @ApiModelProperty(value="停用/启用（0，停用；1，启用）",name="isEnable")
    private String isEnable;

    private List<String> roleIdList;
}
