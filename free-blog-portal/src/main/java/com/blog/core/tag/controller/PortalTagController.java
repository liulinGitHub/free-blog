package com.blog.core.tag.controller;

import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.tag.entity.qo.PortalTagQueryDTO;
import com.blog.core.tag.service.PortalTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: ManageTag
 * @description: 标签Controller
 * @author: liulin
 * @create: 2019-07-23 17:35
 * @Version: 1.0
 */
@Api(value = "标签Controller",tags = "标签信息服务")
@RestController
@RequestMapping("/portal/tag")
public class PortalTagController extends BaseController {

    @Resource
    private PortalTagService portalTagService;

    @ApiOperation(value="分页查询标签信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryTagByPage(PortalTagQueryDTO portalTagQueryDTO, QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.portalTagService.queryTagByPage(portalTagQueryDTO)));
    }

}
