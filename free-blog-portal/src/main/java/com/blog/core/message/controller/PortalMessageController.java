package com.blog.core.message.controller;

import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.message.entity.dto.PortalMessageQueryDTO;
import com.blog.core.message.service.PortalMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: PortalMessageController
 * @description: 消息服务Controller
 * @author: liulin
 * @create: 2019-08-09 14:30
 * @Version: 1.0
 */
@Api(value = "消息服务Controller",tags = "消息服务")
@RestController
@RequestMapping("/portal/message")
public class PortalMessageController extends BaseController {

    @Autowired
    private PortalMessageService portalMessageService;

    @LogPortal("分页查询消息信息")
    @ApiOperation(value="分页查询消息信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryArticleByPage(QueryRequest request, PortalMessageQueryDTO portalMessageQueryDTO){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(request,() -> this.portalMessageService.queryPortalMessageByPage(portalMessageQueryDTO)));
    }
}
