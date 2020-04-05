package com.blog.core.system.onlineuser.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @ClassNmae: ManageOnlineUser
 * @description: 在线用户
 * @Author: liulin
 * @Date: 2020/4/4 18:30
 **/
@Builder
@Data
public class ManageOnlineUser {

    @ApiModelProperty(value="登陆用户名",name="userName")
    private String userName;

    @ApiModelProperty(value="昵称",name="nickName")
    private String nickName;

    @ApiModelProperty(value="性别",name="salt")
    private String sex;

    @ApiModelProperty(value="请求ip地址")
    private String ipAddress;

    @ApiModelProperty(value="请求地址")
    private String address;

    @ApiModelProperty(value="浏览器")
    private String browser;
}
