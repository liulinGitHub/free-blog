package com.blog.core.system.menu.controller;

import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.menu.service.PortalMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PortalMenuController
 * @description: 菜单服务Controller
 * @author: 950103
 * @create: 2019-06-28 16:59
 * @Version: 1.0
 */
@Api(value = "菜单服务Controller",tags = "菜单服务")
@RestController
@RequestMapping("/menu")
public class PortalMenuController {

    @Autowired
    private PortalMenuService portalMenuService;

    @ApiOperation(value = "查询所有菜单信息", notes="")
    @GetMapping("/list")
    public ResponseBo queryPortalMenuList() {
        return ResponseBo.newDataResponse(this.portalMenuService.queryMenuList());
    }

    @ApiOperation(value = "查询用户所有菜单信息", notes="")
    @GetMapping("/user/list")
    public ResponseBo queryUserPortalMenuList() {
        return ResponseBo.newDataResponse(this.portalMenuService.queryUserPortalMenuList());
    }
}
