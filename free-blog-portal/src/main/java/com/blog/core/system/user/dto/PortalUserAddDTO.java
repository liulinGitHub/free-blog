package com.blog.core.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassNmae: PortalUserAddDTO
 * @description: 添加用户信息传参对象
 * @Author: 950103
 * @Date: 2019/4/14 23:46
 **/
@Data
public class PortalUserAddDTO {

    @ApiModelProperty(value="用户id",name="id",hidden = true)
    private String id;

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
;
    @ApiModelProperty(value="个性签名",name="signature")
    private String signature;

    @ApiModelProperty(value="性别",name="gender")
    private String gender;

    private List<String> roleIdList;
}
