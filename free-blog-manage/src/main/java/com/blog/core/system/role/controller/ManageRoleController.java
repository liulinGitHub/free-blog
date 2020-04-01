package com.blog.core.system.role.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.role.service.ManageRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: fee_blog
 * @description: 角色服务Controller
 * @author: liulin
 * @create: 2019-04-27 13:39
 */
@Api(value = "角色服务Controller",tags = "角色服务")
@RestController
@RequestMapping("/api/role")
public class ManageRoleController extends BaseController {

    @Autowired
    private ManageRoleService manageRoleService;

    @LogManage("分页查询角色信息")
    @ApiOperation(value="分页查询角色信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryRoleByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> manageRoleService.queryManageRoleByPage()));
    }

//    @LogPortal("保存用户角色信息")
//    @ApiOperation(value="保存用户角色信息", notes="")
//    @PostMapping("/user/add")
//    public ResponseBo addUserRole(@RequestBody PortalUserRoleAddQO portalUserRoleAddQO){
//        this.portalRoleService.addUserRole(portalUserRoleAddQO);
//        return ResponseBo.ok("保存成功！");
//    }

}
