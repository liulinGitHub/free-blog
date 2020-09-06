package com.blog.core.controller;

import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.dto.ServerLogQueryDTO;
import com.blog.core.service.ServerLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 后台系统操作日志Controller
 * @author: 950103
 * @create: 2019-07-22 10:39
 * @Version: 1.0
 */
@Api(value = "系统操作日志Controller",tags = "操作日志Controller")
@RestController
@RequestMapping("/api/log")
public class ServerLogController extends BaseController {

    @Autowired
    private ServerLogService serverLogService;

    @ApiOperation(value="分页查询前端系统操作日志信息", notes="")
    @PostMapping("/all")
    public ResponseBo queryPortalLogByPage(@RequestBody ServerLogQueryDTO serverLogQueryDTO, QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.serverLogService.queryServerLogByPage(serverLogQueryDTO)));
    }
}
