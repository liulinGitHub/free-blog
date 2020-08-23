package com.blog.core.system.user.dto;

import com.blog.core.system.role.dto.ManageRoleIdDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @description: 修改用户信息参数
 * @Author: 950103
 * @Date: 2019/11/24 1:25
 * @version: 1.0
 **/
@Data
public class ManageUserEditDTO {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("手机号")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户关联的角色ID")
    private List<ManageRoleIdDTO> roles;
}
