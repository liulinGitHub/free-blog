package com.blog.core.system.user.controller;

import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.entity.dto.PortalUserAddDTO;
import com.blog.core.system.user.entity.dto.PortalUserEditDTO;
import com.blog.core.system.user.entity.dto.PortalUserQueryDTO;
import com.blog.core.system.user.service.PortalUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassNmae:UserController
 * @description: 用户服务 Controller
 * @Author:liulin
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
    public ResponseBo queryUser(PortalUserQueryDTO portalUserQueryDTO){
        return ResponseBo.newDataResponse( this.portalUserService.queryUser(portalUserQueryDTO));
    }

    @ApiOperation(value="根据用户id查询用户信息", notes="")
    @GetMapping("/queryUserById")
    public ResponseBo queryUserById(String userId){
        return ResponseBo.newDataResponse( this.portalUserService.queryUserById(userId));
    }

    @ApiOperation(value="添加用户信息", notes="")
    @PostMapping("/add")
    public ResponseBo addUser(@Valid @RequestBody PortalUserAddDTO portalUserAddDTO){
        this.portalUserService.addUser(portalUserAddDTO);
        return ResponseBo.ok("添加成功！");
    }

    @ApiOperation(value="修改用户信息", notes="")
    @PutMapping("/update")
    public ResponseBo updateUser(@Valid @RequestBody PortalUserEditDTO portalUserEditDTO){
        this.portalUserService.updateUser(portalUserEditDTO);
        return ResponseBo.ok("添加成功！");
    }
}
