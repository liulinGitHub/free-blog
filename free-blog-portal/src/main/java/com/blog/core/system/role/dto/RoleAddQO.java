package com.blog.core.system.role.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: RoleAddQO
 * @description: 新增角色信息
 * @author: 950103
 * @create: 2019-06-28 13:56
 * @Version: 1.0
 */
@Data
public class RoleAddQO {

    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value="角色编号")
    private String roleCode;

    @ApiModelProperty(value="角色描述")
    private String roleDescribe;

    private List<String> menuIdList;
}
