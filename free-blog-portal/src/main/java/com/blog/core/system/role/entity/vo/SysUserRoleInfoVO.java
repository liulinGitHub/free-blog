package com.blog.core.system.role.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @ClassNmae: SysBaseUserInfoVO
 * @description: 用户相关信息返回对象
 * @Author: liulin
 * @Date: 2019/4/14 19:55
 **/
@Data
public class SysUserRoleInfoVO {

    @ApiModelProperty(value="用户id",name="username")
    private String id;

    @ApiModelProperty(value="用户id",name="username")
    private String role_name;

    @ApiModelProperty(value="用户id",name="username")
    private String describe;

    @ApiModelProperty(value="用户id",name="username")
    private String status;

    @ApiModelProperty(value="用户id",name="username")
    private Date create_time;

    @ApiModelProperty(value="用户id",name="username")
    private Date update_time;

    @ApiModelProperty(value="用户id",name="username")
    private String create_id;

    @ApiModelProperty(value="用户id",name="username")
    private String update_id;

//    @ApiModelProperty(value="token",name="token")
//    private List<SysBasePermissionInfoVO> permission;
}
