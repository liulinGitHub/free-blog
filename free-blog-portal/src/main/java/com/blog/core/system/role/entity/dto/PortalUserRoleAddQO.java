package com.blog.core.system.role.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: UserRoleAddQO
 * @description: 添加用户角色信息
 * @author: liulin
 * @create: 2019-06-28 15:04
 * @Version: 1.0
 */
@Data
public class PortalUserRoleAddQO {

    @ApiModelProperty(value="用户id")
    private String userId;

    @ApiModelProperty(value="角色id")
    private String roleId;
}
