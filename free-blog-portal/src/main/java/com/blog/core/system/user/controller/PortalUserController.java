package com.blog.core.system.user.controller;

import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.dto.PortalUserAddDTO;
import com.blog.core.system.user.dto.PortalUserEditDTO;
import com.blog.core.system.user.dto.PortalUserQueryDTO;
import com.blog.core.system.user.service.PortalUserService;
import io.lettuce.core.dynamic.annotation.Param;
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

    @ApiOperation(value="分页查询用户信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryPortalUser(PortalUserQueryDTO portalUserQueryDTO){
        return ResponseBo.newDataResponse( this.portalUserService.queryPortalUser(portalUserQueryDTO));
    }

    @ApiOperation(value="根据用户id查询用户信息", notes="")
    @GetMapping("/details/{userId}")
    public ResponseBo queryPortalUserDetails(@PathVariable("userId") String userId){
        return ResponseBo.newDataResponse( this.portalUserService.queryPortalUserDetails(userId));
    }

    @ApiOperation(value="添加用户信息", notes="")
    @PostMapping("/save")
    public ResponseBo savePortalUser(@Valid @RequestBody PortalUserAddDTO portalUserAddDTO){
        this.portalUserService.savePortalUser(portalUserAddDTO);
        return ResponseBo.ok("添加成功！");
    }

    @ApiOperation(value="修改用户信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editPortalUser(@Valid @RequestBody PortalUserEditDTO portalUserEditDTO){
        this.portalUserService.editPortalUser(portalUserEditDTO);
        return ResponseBo.ok("添加成功！");
    }
}
