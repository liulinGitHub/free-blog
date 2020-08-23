package com.blog.core.system.user.controller;

import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.service.PortalUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tio.http.common.HttpRequest;

/**
 * @ClassNmae: UserLoginController
 * @description: 用户登陆Controller
 * @Author: 950103
 * @Date: 2019/4/11 23:19
 **/
@Api(value = "用户登陆Controller",tags = "用户登陆")
@RestController
@RequestMapping("/user")
public class PortalUserLoginController {

    @Autowired
    private PortalUserService portalUserService;

    @ApiOperation(value="获取用户相关信息", notes="")
    @GetMapping("/info")
    public ResponseBo queryUserInfo() {
        return ResponseBo.newDataResponse(this.portalUserService.queryUserInfo());
    }

    @ApiOperation(value="退出登陆", notes="")
    @GetMapping("/logout")
    public ResponseBo logout(HttpRequest httpRequest) {
        return ResponseBo.ok("退出登陆!");
    }
}
