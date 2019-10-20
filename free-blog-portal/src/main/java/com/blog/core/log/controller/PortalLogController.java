package com.blog.core.log.controller;

import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.log.entity.dto.PortalLogQueryDTO;
import com.blog.core.log.service.PortalLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ManageLogController
 * @description: 前台系统操作日志Controller
 * @author: liulin
 * @create: 2019-07-22 10:39
 * @Version: 1.0
 */
@Api(value = "前台系统操作日志Controller",tags = "操作日志Controller")
@RestController
@RequestMapping("/portal/log")
public class PortalLogController extends BaseController {

    @Autowired
    private PortalLogService portalLogService;

    @LogManage("分页查询前台系统操作日志信息")
    @ApiOperation(value="分页查询前台系统操作日志信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryLogByPage(PortalLogQueryDTO portalLogQueryDTO, QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.portalLogService.queryLogByPage(portalLogQueryDTO)));
    }
}
