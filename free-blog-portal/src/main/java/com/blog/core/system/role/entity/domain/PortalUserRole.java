package com.blog.core.system.role.entity.domain;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: UserRole
 * @description: 用户角色关联信息
 * @author: liulin
 * @create: 2019-06-28 15:54
 * @Version: 1.0
 */
@Data
public class PortalUserRole extends BaseModel {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("用户ID")
    private String userId;
}
