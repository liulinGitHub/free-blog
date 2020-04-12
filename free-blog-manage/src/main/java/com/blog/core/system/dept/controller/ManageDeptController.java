package com.blog.core.system.dept.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.auth.utils.SecurityUtils;
import com.blog.core.system.dept.dto.ManageDeptAddDTO;
import com.blog.core.system.dept.dto.ManageDeptEditDTO;
import com.blog.core.system.dept.service.ManageDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae: ManageDeptController
 * @description: 部门Controller
 * @Author: liulin
 * @Date: 2020/3/31 14:50
 **/
@Api(value = "部门Controller",tags = "部门服务")
@RestController
@RequestMapping("/api/dept")
public class ManageDeptController extends BaseController {

    @Autowired
    private ManageDeptService manageDeptService;

    @ApiOperation(value="分页查询部门信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryManageDeptByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> manageDeptService.queryManageDeptByPage()));
    }

    @ApiOperation(value="查询前端所需的部门", notes="")
    @GetMapping("/all")
    public ResponseBo queryManageDept(){
        return ResponseBo.newDataResponse(manageDeptService.builderDeptTree());
    }

    @LogManage("添加部门信息")
    @ApiOperation(value="添加部门信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageDept(@RequestBody ManageDeptAddDTO manageDeptAddDTO){
        this.manageDeptService.addManageDept(manageDeptAddDTO);
        return ResponseBo.ok("添加岗位信息成功！");
    }

    @LogManage("修改部门信息")
    @ApiOperation(value="修改部门信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editManageDept(@RequestBody ManageDeptEditDTO manageDeptEditDTO){
        this.manageDeptService.editManageDept(manageDeptEditDTO);
        return ResponseBo.ok("修改岗位信息成功！");
    }
}
