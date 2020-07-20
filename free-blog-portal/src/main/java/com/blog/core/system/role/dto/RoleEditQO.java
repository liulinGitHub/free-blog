package com.blog.core.system.role.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: RoleEditQO
 * @description: 修改角色信息
 * @author: 950103
 * @create: 2019-06-28 13:59
 * @Version: 1.0
 */
@Data
public class RoleEditQO {

    @ApiModelProperty(value="角色Id")
    private String id;

    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value="角色编码")
    private String roleCode;

    @ApiModelProperty(value="角色描述")
    private String roleDescribe;

    private List<String> menuIdList;
}
