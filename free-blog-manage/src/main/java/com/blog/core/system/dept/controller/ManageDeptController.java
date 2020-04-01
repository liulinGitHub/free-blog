package com.blog.core.system.dept.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.dept.service.ManageDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @LogManage("分页查询部门信息")
    @ApiOperation(value="分页查询部门信息", notes="")
    @GetMapping
    public ResponseBo queryManageDeptByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> manageDeptService.queryManageDeptByPage()));
    }
}
