package com.blog.core.system.role.entity;

import com.blog.core.common.entity.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 用户角色关联
 * @Author: 950103
 * @Date: 2020/4/1 12:35
 * @version: 1.0
 **/
@Data
public class ManageUserRole extends BaseModel {

    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("角色id")
    private Integer roleId;
}
