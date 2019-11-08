package com.blog.core.system.role.entity.domain;

import com.blog.core.common.entity.BaseModel;
import com.blog.core.common.enums.IsEnableEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.ConfigAttribute;

/**
 * @ClassNmae: SysBaseRole
 * @description: 角色
 * @Author: liulin
 * @Date: 2019/4/18 23:48
 **/
@AllArgsConstructor
@Data
public class PortalRole extends BaseModel implements ConfigAttribute {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编号")
    private String roleCode;

    @ApiModelProperty(value="角色描述")
    private String roleDescribe;

    @ApiModelProperty("启用/停用")
    private IsEnableEnum isEnable;

    @Override
    public String getAttribute() {
        return this.roleId;
    }
}
