package com.blog.core.system.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalCommentUser
 * @Description: 评论者的用户信息
 * @Author: liulin
 * @Date: 2020/4/21 22:48
 * @Version 1.0
 */
@Data
public class PortalCommentUser {

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="头像",name="avatar")
    private String avatar;
}
