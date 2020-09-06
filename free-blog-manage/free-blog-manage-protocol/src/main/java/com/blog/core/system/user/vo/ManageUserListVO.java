package com.blog.core.system.user.vo;

import com.blog.core.system.role.vo.ManageRoleInfoVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @description: 用户信息返回VO参数
 * @author: 950103
 * @create_time: 2019/11/24 1:13
 * @version: 1.0
 **/
@Data
public class ManageUserListVO {

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    private String userName;

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

    @ApiModelProperty("启用/停用")
    private String enable;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createName;

    @ApiModelProperty("角色信息")
    private List<ManageRoleInfoVO> roles;
}
