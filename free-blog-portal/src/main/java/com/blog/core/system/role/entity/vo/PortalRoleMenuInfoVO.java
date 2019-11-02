package com.blog.core.system.role.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: PortalRoleMenuInfoVO
 * @description: 角色用户信息
 * @author: liulin
 * @create: 2019-10-30 15:48
 * @Version: 1.0
 */
@Data
public class PortalRoleMenuInfoVO {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty("角色描述")
    private String roleDescribe;

    @ApiModelProperty("启用/停用")
    private String isEnable;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<String> menuIdList;
}
