package com.blog.core.system.job.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.system.job.dto.ManageJobAddDTO;
import com.blog.core.system.job.dto.ManageJobEditDTO;
import com.blog.core.system.job.service.ManageJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 岗位Controller
 * @author: 950103
 * @create_time: 2020/4/12 17:24
 * @version: 1.0
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
    public ResponseBo addManageJob(@RequestBody @Valid ManageJobAddDTO manageJobAddDTO){
        this.manageJobService.addManageJob(manageJobAddDTO);
        return ResponseBo.ok();
    }

    @LogManage("修改岗位信息")
    @ApiOperation(value="修改岗位信息", notes="")
    @PutMapping("/edit")
    public ResponseBo editManageJob(@RequestBody @Valid ManageJobEditDTO manageJobEditDTO){
        this.manageJobService.editManageJob(manageJobEditDTO);
        return ResponseBo.ok();
    }
}
