package com.blog.core.system.role.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.role.dto.RoleAddDTO;
import com.blog.core.system.role.dto.RoleEditDTO;
import com.blog.core.system.role.service.RoleService;
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
@RequestMapping("/sys/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @LogManage("分页查询角色信息")
    @ApiOperation(value="分页查询角色信息", notes="")
    @GetMapping("/queryPage")
    public ResponseBo queryRoleByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> roleService.queryRoleByPage()));
    }

    @LogManage("分页查询角色信息")
    @ApiOperation(value="分页查询角色信息", notes="")
    @PostMapping("/list")
    public ResponseBo queryRoleList() {
        return ResponseBo.newDataResponse(roleService.queryRoleList());
    }

    @LogManage("查看角色信息详情")
    @ApiOperation(value="查看角色信息详情", notes="")
    @GetMapping("/details/{roleId}")
    public ResponseBo queryRoleDetails(@PathVariable("roleId") Integer roleId){
        return ResponseBo.newDataResponse(this.roleService.queryRoleDetails(roleId));
    }

    @LogManage("添加角色信息")
    @ApiOperation(value="添加角色信息", notes="")
    @PostMapping("/add")
    public ResponseBo addRole(@RequestBody @Valid RoleAddDTO RoleAddDTO) {
        this.roleService.addRole(RoleAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改角色信息")
    @ApiOperation(value="修改角色信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editRole(@RequestBody @Valid RoleEditDTO RoleEditDTO) {
        this.roleService.editRole(RoleEditDTO);
        return ResponseBo.ok();
    }

    @LogManage("禁用角色信息")
    @ApiOperation(value="禁用角色信息", notes="")
    @GetMapping("/disable/{roleId}")
    public ResponseBo disableRole(@PathVariable("roleId") Integer roleId) {
        this.roleService.disableRole(roleId);
        return ResponseBo.ok();
    }

    @LogManage("启用角色信息")
    @ApiOperation(value="启用角色信息", notes="")
    @GetMapping("/enable/{roleId}")
    public ResponseBo enableRoleByRoleId(@PathVariable("roleId") Integer roleId) {
        this.roleService.enableRole(roleId);
        return ResponseBo.ok();
    }

}
