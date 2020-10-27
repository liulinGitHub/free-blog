package com.blog.core.system.role.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 角色详情
 * @author: 950103
 * @create_time: 2020/10/6 18:03
 * @version 1.0
 */
@Data
public class RoleDetailsVO {

    @ApiModelProperty("角色id")
    private Integer roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDescribe;

    @ApiModelProperty("启用/停用")
    private String enable;
}
