package com.blog.core.system.role.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: PortalUserRole
 * @description: 用户角色关联信息
 * @author: 950103
 * @create: 2019-06-28 15:54
 * @Version: 1.0
 */
@Data
public class PortalUserRole extends BaseModel {

    @ApiModelProperty(" 用户角色关联ID")
    private String userRoleId;

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("用户ID")
    private String userId;
}
