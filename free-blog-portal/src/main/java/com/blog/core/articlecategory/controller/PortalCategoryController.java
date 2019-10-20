package com.blog.core.articlecategory.controller;

import com.blog.core.articlecategory.service.PortalArticleCategoryService;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: free-blog
 * @description: 文章分类
 * @author: liulin
 * @create: 2019-05-05 18:20
 */
@Api(value = "文章分类服务Controller",tags = "文章分类服务")
@RestController
@RequestMapping("/category")
public class PortalCategoryController {

    @Autowired
    private PortalArticleCategoryService portalArticleCategoryService;

    @LogPortal("分页文章分类信息")
    @ApiOperation(value="分页文章分类信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryCategoryByPage(){
        return ResponseBo.newDataResponse(this.portalArticleCategoryService.queryCategoryByPage());
    }
}
