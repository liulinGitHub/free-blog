package com.blog.core.system.job.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.dept.service.ManageDeptService;
import com.blog.core.system.job.dto.ManageJobAddDTO;
import com.blog.core.system.job.dto.ManageJobEditDTO;
import com.blog.core.system.job.service.ManageJobService;
import com.blog.core.system.user.dto.ManageUserAddDTO;
import com.blog.core.system.user.dto.ManageUserEditDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae: ManageJobController
 * @description: 岗位Controller
 * @Author: liulin
 * @Date: 2020/4/12 17:24
 **/
@Api(value = "岗位Controller",tags = "岗位服务")
@RestController
@RequestMapping("/api/job")
public class ManageJobController extends BaseController {

    @Autowired
    private ManageJobService manageJobService;

    @ApiOperation(value="分页查询岗位信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryManageJobByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> manageJobService.queryManageJobByPage()));
    }

    @LogManage("添加岗位信息")
    @ApiOperation(value="添加岗位信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageJob(@RequestBody ManageJobAddDTO manageJobAddDTO){
        this.manageJobService.addManageJob(manageJobAddDTO);
        return ResponseBo.ok("添加岗位信息成功！");
    }

    @LogManage("修改岗位信息")
    @ApiOperation(value="修改岗位信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editManageJob(@RequestBody ManageJobEditDTO manageJobEditDTO){
        this.manageJobService.editManageJob(manageJobEditDTO);
        return ResponseBo.ok("修改岗位信息成功！");
    }
}
