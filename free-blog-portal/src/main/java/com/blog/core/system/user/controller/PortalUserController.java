package com.blog.core.system.user.controller;

import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.service.PortalUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassNmae: PortalUserController
 * @description: 用户服务 Controller
 * @Author: 950103
 * @Date: 2019/4/6 15:37
 **/
@Api(value = "用户服务Controller",tags = "用户服务")
@RestController
@RequestMapping("/user")
public class PortalUserController {

    @Autowired
    private PortalUserService portalUserService;

}
