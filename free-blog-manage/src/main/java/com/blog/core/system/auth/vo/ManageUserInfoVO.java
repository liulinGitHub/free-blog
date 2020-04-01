package com.blog.core.system.auth.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ClassNmae: ManageUserInfoVO
 * @description: 用户详情信息
 * @Author: liulin
 * @Date: 2020/3/31 16:33
 **/
@Data
public class ManageUserInfoVO {

    @ApiModelProperty(value="用户id")
    private String userId;

    @ApiModelProperty(value="登陆用户名")
    private String userName;

    @ApiModelProperty(value="昵称")
    private String nickName;

    @ApiModelProperty(value="性别")
    private String sex;

    @ApiModelProperty(value="头像")
    private String avatar;

    @ApiModelProperty(value="电话号码")
    private String telephone;

    @ApiModelProperty(value="邮箱")
    private String email;

    @ApiModelProperty(value="权限")
    private Set<String> roles;
}
