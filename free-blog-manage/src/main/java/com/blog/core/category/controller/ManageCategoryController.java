package com.blog.core.category.controller;

import com.blog.core.category.dto.ManageCategoryAddDTO;
import com.blog.core.category.dto.ManageCategoryEditDTO;
import com.blog.core.category.dto.ManageCategoryIdDTO;
import com.blog.core.category.service.ManageCategoryService;
import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: free-blog
 * @description: 分类服务Controller
 * @author: liulin
 * @create: 2019-05-05 18:20
 */
@Api(value = "分类服务Controller",tags = "文章分类服务")
@RestController
@RequestMapping("/category")
public class ManageCategoryController extends BaseController {

    @Autowired
    private ManageCategoryService manageCategoryService;

    @LogPortal("分页文章分类信息")
    @ApiOperation(value="分页文章分类信息", notes="")
    @GetMapping("/all")
    public ResponseBo queryManageCategoryByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () ->
                this.manageCategoryService.queryManageCategoryByPage()));
    }

    @LogPortal("查看分类详情")
    @ApiOperation(value="查看分类详情", notes="")
    @GetMapping("/details")
    public ResponseBo queryManageCategoryDetails(String categoryId){
        return ResponseBo.newDataResponse(this.manageCategoryService.queryManageCategoryByCategoryId(categoryId));
    }

    @LogPortal("添加分类信息")
    @ApiOperation(value="添加分类信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageCategory(@RequestBody ManageCategoryAddDTO manageCategoryAddDTO){
        this.manageCategoryService.addManageCategory(manageCategoryAddDTO);
        return ResponseBo.ok("添加分类信息成功！");
    }

    @LogPortal("修改分类信息")
    @ApiOperation(value="修改分类信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editManageCategory(@RequestBody ManageCategoryEditDTO manageCategoryEditDTO) {
        this.manageCategoryService.editManageCategory(manageCategoryEditDTO);
        return ResponseBo.ok("修改分类信息成功！");
    }

    @LogManage("启用分类信息")
    @ApiOperation(value="启用分类信息", notes="")
    @PostMapping("/enable")
    public ResponseBo enableManageCategory(@RequestBody ManageCategoryIdDTO manageCategoryIdDTO){
        this.manageCategoryService.enableManageCategoryByCategoryId(manageCategoryIdDTO);
        return ResponseBo.ok("启用成功!");
    }

    @LogManage("停用分类信息")
    @ApiOperation(value="停用分类信息", notes="")
    @PostMapping("/disable")
    public ResponseBo disableManageCategory(@RequestBody ManageCategoryIdDTO manageCategoryIdDTO){
        this.manageCategoryService.disableManageCategoryByCategoryId(manageCategoryIdDTO);
        return ResponseBo.ok("停用成功!");
    }
}
