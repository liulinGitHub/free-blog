package com.blog.core.system.role.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.access.ConfigAttribute;

import java.util.Date;

/**
 * @ClassNmae: SysBaseRole
 * @description: 角色vo
 * @Author: 950103
 * @Date: 2019/4/18 23:48
 **/
@Data
public class PortalRoleVO implements ConfigAttribute {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty("角色描述")
    private String roleDescribe;

    @ApiModelProperty("启用/停用")
    private String enable;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Override
    public String getAttribute() {
        return this.roleCode;
    }

    public PortalRoleVO(String roleId, String roleName, String roleCode) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCode = roleCode;
    }
}
