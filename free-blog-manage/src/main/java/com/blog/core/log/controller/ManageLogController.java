package com.blog.core.log.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.log.entity.dto.ManageLogQueryDTO;
import com.blog.core.log.service.ManageLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ManageLogController
 * @description: 后台系统操作日志Controller
 * @author: liulin
 * @create: 2019-07-22 10:39
 * @Version: 1.0
 */
@Api(value = "后台系统操作日志Controller",tags = "操作日志Controller")
@RestController
@RequestMapping("/portal/log")
public class ManageLogController extends BaseController {

    @Autowired
    private ManageLogService manageLogService;

    @LogManage("分页查询后台系统操作日志信息")
    @ApiOperation(value="分页查询后台系统操作日志信息", notes="")
    @PostMapping("/query")
    public ResponseBo queryLogByPage(@RequestBody ManageLogQueryDTO manageLogQueryDTO, QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageLogService.queryLogByPage(manageLogQueryDTO)));
    }
}
