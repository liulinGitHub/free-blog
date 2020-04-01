package com.blog.core.system.user.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.auth.entity.SecurityUser;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import com.blog.core.system.user.service.ManageUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae: ManageUserController
 * @description: 用户信息服务Controller
 * @Author: liulin
 * @Date: 2019/11/24 1:07
 **/
@Api(value = "用户信息服务Controller",tags = "用户信息服务")
@RestController
@RequestMapping("/api/user")
public class ManageUserController extends BaseController {

    @Autowired
    private ManageUserService manageUserService;

    @LogManage("分页查询用户信息")
    @ApiOperation(value="分页查询用户信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryUserByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageUserService.queryUserByPage()));
    }

    @LogManage("查看用户详细信息")
    @ApiOperation(value="查看用户详细信息", notes="")
    @GetMapping("/details/{userId}")
    public ResponseBo queryUserByUserId(@PathVariable("userId") String userId){
        SecurityUser user = SecurityUtils.getUser();
        System.out.println(user);
        return ResponseBo.newDataResponse(this.manageUserService.queryUserByUserId(userId));
    }

    @LogManage("添加用户信息")
    @ApiOperation(value="添加用户信息", notes="")
    @PostMapping("/add")
    public ResponseBo addUser(@RequestBody ManageUserAddDTO manageUserAddDTO){
        this.manageUserService.addUser(manageUserAddDTO);
        return ResponseBo.ok("添加用户信息成功！");
    }

    @LogManage("修改用户信息")
    @ApiOperation(value="修改用户信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editUser(@RequestBody ManageUserEditDTO manageUserEditDTO){
        this.manageUserService.editManageUser(manageUserEditDTO);
        return ResponseBo.ok("修改用户信息成功！");
    }

    @LogManage("禁用用户")
    @ApiOperation(value="禁用用户", notes="")
    @GetMapping("/disable")
    public ResponseBo disableUserByUserId(@PathVariable String userId){
        this.manageUserService.disableUserByUserId(userId);
        return ResponseBo.ok("禁用用户成功！");
    }

    @LogManage("启用用户")
    @ApiOperation(value="启用用户", notes="")
    @GetMapping("/enable")
    public ResponseBo enableUserByUserId(@PathVariable String userId){
        this.manageUserService.enableUserByUserId(userId);
        return ResponseBo.ok("启用用户成功！");
    }
}
