package com.blog.core.articlecategory.controller;

import com.blog.core.articlecategory.entity.dto.ManageCategoryAddDTO;
import com.blog.core.articlecategory.entity.dto.ManageCategoryEditDTO;
import com.blog.core.articlecategory.service.ManageArticleCategoryService;
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
public class ManageCategoryController {

    @Autowired
    private ManageArticleCategoryService manageArticleCategoryService;

    @LogPortal("分页文章分类信息")
    @ApiOperation(value="分页文章分类信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryArticleCategoryByPage(){
        return ResponseBo.newDataResponse(this.manageArticleCategoryService.queryArticleCategoryByPage());
    }

    @LogPortal("分页文章分类信息")
    @ApiOperation(value="分页文章分类信息", notes="")
    @GetMapping("/details")
    public ResponseBo queryArticleCategoryByCategoryId(String categoryId){
        return ResponseBo.newDataResponse(this.manageArticleCategoryService.queryArticleCategoryByCategoryId(categoryId));
    }

    @LogPortal("添加文章分类信息")
    @ApiOperation(value="添加文章分类信息", notes="")
    @PostMapping("/add")
    public ResponseBo addArticleCategory(@RequestBody ManageCategoryAddDTO manageCategoryAddDTO){
        this.manageArticleCategoryService.addArticleCategory(manageCategoryAddDTO);
        return ResponseBo.ok("添加分类信息成功！");
    }

    @LogPortal("修改文章分类信息")
    @ApiOperation(value="修改文章分类信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editArticleCategory(@RequestBody ManageCategoryEditDTO manageCategoryEditDTO) {
        this.manageArticleCategoryService.editArticleCategory(manageCategoryEditDTO);
        return ResponseBo.ok("修改分类信息成功！");
    }
}
