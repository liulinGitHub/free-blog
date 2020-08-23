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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

/**
 * @description: 用户信息服务Controller
 * @author: 950103
 * @date: 2019/11/24 1:07
 * @version: 1.0
 **/
@Api(value = "用户信息服务Controller",tags = "用户信息服务")
@RestController
@RequestMapping("/user")
public class ManageUserController extends BaseController {

    @Autowired
    private ManageUserService manageUserService;

    @LogManage("分页查询用户信息")
    @ApiOperation(value="分页查询用户信息", notes="")
    @GetMapping("/list")
    public ResponseBo queryManageUserByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageUserService.queryManageUserByPage()));
    }

    @LogManage("查看用户详细信息")
    @ApiOperation(value="查看用户详细信息", notes="")
    @GetMapping("/details/{userId}")
    public ResponseBo queryUserByUserId(@PathVariable("userId") String userId) {
        return ResponseBo.newDataResponse(this.manageUserService.queryUserByUserId(userId));
    }

    @LogManage("添加用户信息")
    @ApiOperation(value="添加用户信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageUser(@RequestBody ManageUserAddDTO manageUserAddDTO) {
        this.manageUserService.addManageUser(manageUserAddDTO);
        return ResponseBo.ok("添加用户信息成功！");
    }

    @LogManage("修改用户信息")
    @ApiOperation(value="修改用户信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editManageUser(@RequestBody ManageUserEditDTO manageUserEditDTO) {
        this.manageUserService.editManageUser(manageUserEditDTO);
        return ResponseBo.ok("修改用户信息成功！");
    }

    @LogManage("禁用用户")
    @ApiOperation(value="禁用用户", notes="")
    @GetMapping("/disable/{userId}")
    public ResponseBo disableUserByUserId(@PathVariable("userId") String userId){
        this.manageUserService.disableUserByUserId(userId);
        return ResponseBo.ok("禁用用户成功！");
    }

    @LogManage("启用用户")
    @ApiOperation(value="启用用户", notes="")
    @GetMapping("/enable/{userId}")
    public ResponseBo enableUserByUserId(@PathVariable("userId") String userId){
        this.manageUserService.enableUserByUserId(userId);
        return ResponseBo.ok("启用用户成功！");
    }
}
