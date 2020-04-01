package com.blog.core.system.role.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassNmae: ManageUserRole
 * @description: 用户角色关联
 * @Author: liulin
 * @Date: 2020/4/1 12:35
 **/
@Data
public class ManageUserRole extends BaseModel {

    private String id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("角色id")
    private String roleId;
}
