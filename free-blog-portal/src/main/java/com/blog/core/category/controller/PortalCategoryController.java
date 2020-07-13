package com.blog.core.category.controller;

import com.blog.core.category.service.PortalCategoryService;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassNmae: PortalCategoryController
 * @description: 文章分类服务Controller
 * @author: 950103
 * @create: 2019-05-05 18:20
 */
@Api(value = "文章分类服务Controller",tags = "文章分类服务")
@RestController
@RequestMapping("/category")
public class PortalCategoryController {

    @Autowired
    private PortalCategoryService portalCategoryService;

    @ApiOperation(value="分页文章分类信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryCategoryByPage(){
        return ResponseBo.newDataResponse(this.portalCategoryService.queryCategoryByPage());
    }
}
