package com.blog.core.controller;

import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.dto.ManageLogQueryDTO;
import com.blog.core.service.ManageLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ManageLogController
 * @description: 后台系统操作日志Controller
 * @author: liulin
 * @create: 2019-07-22 10:39
 * @Version: 1.0
 */
@Api(value = "后台系统操作日志Controller",tags = "操作日志Controller")
@RestController
@RequestMapping("/api/log")
public class ManageLogController extends BaseController {

    @Autowired
    private ManageLogService manageLogService;

    @ApiOperation(value="分页查询后台系统操作日志信息", notes="")
    @PostMapping("/query")
    public ResponseBo queryLogByPage(@RequestBody ManageLogQueryDTO manageLogQueryDTO, QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageLogService.queryLogByPage(manageLogQueryDTO)));
    }

    @ApiOperation(value="分页查询后台系统操作日志信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryLogByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageLogService.queryLogByPage(null)));
    }
}
