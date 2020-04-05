package com.blog.core.system.role.controller;

import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.role.entity.dto.PortalUserRoleAddQO;
import com.blog.core.system.role.service.PortalRoleService;
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
@RequestMapping("/role")
public class PortalRoleController {

    @Autowired
    private PortalRoleService portalRoleService;

    @ApiOperation(value="分页查询角色信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryRoleByPage(QueryRequest queryRequest){
        //this.roleService.queryRoleByPage();
        return ResponseBo.newDataResponse(null);
    }

    @ApiOperation(value="保存用户角色信息", notes="")
    @PostMapping("/user/add")
    public ResponseBo addUserRole(@RequestBody PortalUserRoleAddQO portalUserRoleAddQO){
        this.portalRoleService.addUserRole(portalUserRoleAddQO);
        return ResponseBo.ok("保存成功！");
    }

}
