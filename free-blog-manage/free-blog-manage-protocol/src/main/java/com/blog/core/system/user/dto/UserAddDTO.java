package com.blog.core.system.user.dto;

import com.blog.core.common.enums.EnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @description: 添加用户信息参数
 * @author: 950103
 * @create_time: 2019/11/24 1:25
 * @version: 1.0
 **/
@Data
public class UserAddDTO {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    private String gender;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    private String telephone;

    @ApiModelProperty("邮箱")
    @NotNull(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("停用/启用")
    private EnableEnum enable;

    @ApiModelProperty("用户关联的角色ID")
    private List<Integer> roleIdList;
}
