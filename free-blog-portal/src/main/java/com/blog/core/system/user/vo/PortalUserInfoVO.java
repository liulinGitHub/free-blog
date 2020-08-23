package com.blog.core.system.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: PortalUserInfoVO
 * @description: 登陆信息返回对象
 * @Author: 950103
 * @Date: 2019/4/14 19:55
 **/
@Data
public class PortalUserInfoVO {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("登陆用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("个性签名")
    private String signature;
}
