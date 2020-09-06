package com.blog.core.system.role.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.role.dto.ManageRoleAddDTO;
import com.blog.core.system.role.dto.ManageRoleEditDTO;
import com.blog.core.system.role.service.ManageRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 角色服务Controller
 * @date: 2019-04-27 13:39
 * @create_time: 950103
 * @version: 1.0
 */
@Api(value = "角色服务Controller",tags = "角色服务")
@RestController
@RequestMapping("/role")
public class ManageRoleController extends BaseController {

    @Autowired
    private ManageRoleService manageRoleService;

    @LogManage("分页查询角色信息")
    @ApiOperation(value="分页查询角色信息", notes="")
    @GetMapping("/list")
    public ResponseBo queryManageRoleByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> manageRoleService.queryManageRoleByPage()));
    }


    @LogManage("查看角色信息详情")
    @ApiOperation(value="查看角色信息详情", notes="")
    @GetMapping("/details/{roleId}")
    public ResponseBo queryManageRoleDetails(@PathVariable("roleId") Integer roleId){
        return ResponseBo.newDataResponse(this.manageRoleService.queryManageRoleDetails(roleId));
    }

    @LogManage("添加角色信息")
    @ApiOperation(value="添加角色信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageRole(@RequestBody @Valid ManageRoleAddDTO manageRoleAddDTO) {
        this.manageRoleService.addManageRole(manageRoleAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改角色信息")
    @ApiOperation(value="修改角色信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editManageRole(@RequestBody @Valid ManageRoleEditDTO manageRoleEditDTO) {
        this.manageRoleService.editManageRole(manageRoleEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("禁用角色信息")
    @ApiOperation(value="禁用角色信息", notes="")
    @GetMapping("/disable/{roleId}")
    public ResponseBo disableManageRole(@PathVariable("roleId") Integer roleId) {
        this.manageRoleService.disableManageRole(roleId);
        return ResponseBo.ok();
    }

    @LogManage("启用角色信息")
    @ApiOperation(value="启用角色信息", notes="")
    @GetMapping("/enable/{roleId}")
    public ResponseBo enableManageRoleByRoleId(@PathVariable("roleId") Integer roleId) {
        this.manageRoleService.enableManageRole(roleId);
        return ResponseBo.ok();
    }

}
