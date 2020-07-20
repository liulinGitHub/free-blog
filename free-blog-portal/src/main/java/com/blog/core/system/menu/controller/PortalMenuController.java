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

    @ApiOperation(value="保存角色菜单信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryUserMenu(){
        return ResponseBo.newDataResponse(this.portalMenuService.queryUserMenu());
    }
}
