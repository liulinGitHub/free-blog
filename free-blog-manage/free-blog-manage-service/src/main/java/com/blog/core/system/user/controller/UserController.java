package com.blog.core.system.user.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.user.dto.UserAddDTO;
import com.blog.core.system.user.dto.UserEditDTO;
import com.blog.core.system.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 用户信息服务Controller
 * @author: 950103
 * @create_time: 2019/11/24 1:07
 * @version: 1.0
 **/
@Api(value = "用户信息服务Controller",tags = "用户信息服务")
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @LogManage("分页查询用户信息")
    @ApiOperation(value="分页查询用户信息", notes="")
    @GetMapping("/queryPage")
    public ResponseBo queryUserByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.userService.queryUserByPage()));
    }

    @LogManage("查看用户详细信息")
    @ApiOperation(value="查看用户详细信息", notes="")
    @GetMapping("/details/{userId}")
    public ResponseBo queryUserDetails(@PathVariable("userId") Integer userId) {
        return ResponseBo.newDataResponse(this.userService.queryUserDetails(userId));
    }

    @LogManage("添加用户信息")
    @ApiOperation(value="添加用户信息", notes="")
    @PostMapping("/add")
    public ResponseBo addUser(@Valid @RequestBody UserAddDTO userAddDTO) {
        this.userService.addUser(userAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改用户信息")
    @ApiOperation(value="修改用户信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editUser(@Valid @RequestBody UserEditDTO userEditDTO) {
        this.userService.editUser(userEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("禁用用户")
    @ApiOperation(value="禁用用户", notes="")
    @GetMapping("/disable/{userId}")
    public ResponseBo disableUserByUserId(@PathVariable("userId") Integer userId){
        this.userService.disableUserByUserId(userId);
        return ResponseBo.ok();
    }

    @LogManage("启用用户")
    @ApiOperation(value="启用用户", notes="")
    @GetMapping("/enable/{userId}")
    public ResponseBo enableUserByUserId(@PathVariable("userId") Integer userId){
        this.userService.enableUserByUserId(userId);
        return ResponseBo.ok();
    }
}
