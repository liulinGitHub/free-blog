package com.blog.core.system.menu.entity.dto;

import com.blog.core.common.enums.MenuTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: RoleAddQO
 * @description: 新增菜单信息
 * @author: liulin
 * @create: 2019-06-28 13:56
 * @Version: 1.0
 */
@Data
public class MenuAddQO {

    @ApiModelProperty(value="菜单名称")
    private String menuName;

    @ApiModelProperty("返回给前端的标识（如新增 add）")
    private String webCode;

    @ApiModelProperty("菜单URL")
    private String menuUrl;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单排序号(越小在前面)")
    private String menuSort;

    @ApiModelProperty("菜单或按钮(MENU :菜单，BUTTON：按钮)")
    private MenuTypeEnum menuType;
}
