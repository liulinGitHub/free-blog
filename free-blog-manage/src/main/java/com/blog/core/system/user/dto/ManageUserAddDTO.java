package com.blog.core.system.user.dto;

import com.blog.core.system.role.dto.ManageRoleIdDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 添加用户信息参数
 * @author: 950103
 * @date: 2019/11/24 1:25
 * @version: 1.0
 **/
@Data
public class ManageUserAddDTO {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("用户昵称")
    @NotNull(message = "用户昵称不能为空")
    private String nickName;

    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    private String gender;

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    private String telephone;

    @ApiModelProperty("邮箱")
    @NotNull(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("用户关联的角色ID")
    private List<String> roleIds;
}
