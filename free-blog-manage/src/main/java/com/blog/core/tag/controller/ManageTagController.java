package com.blog.core.tag.controller;

import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import com.blog.core.tag.dto.ManageTagAddDTO;
import com.blog.core.tag.dto.ManageTagEditDTO;
import com.blog.core.tag.dto.ManageTagIdDTO;
import com.blog.core.tag.service.ManageTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ManageTagController
 * @description: 标签信息服务Controller
 * @author: liulin
 * @create: 2019-12-16 15:17
 * @Version: 1.0
 */
@Api(value = "标签信息服务Controller",tags = "标签信息服务Controller")
@RestController
@RequestMapping("/tag")
public class ManageTagController extends BaseController {

    @Autowired
    private ManageTagService manageTagService;

    @ApiOperation(value="分页查询文章评论信息", notes="")
    @PostMapping("/all")
    public ResponseBo queryManageTagByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageTagService.queryManageTagByPage()));
    }

    @ApiOperation(value="查看标签信息详情", notes="")
    @GetMapping("/details")
    public ResponseBo queryManageTagDetails(String tagId){
        return ResponseBo.newDataResponse(this.manageTagService.queryManageTagByTagId(tagId));
    }

    @ApiOperation(value="添加标签信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageTag(@RequestBody ManageTagAddDTO manageTagAddDTO){
        this.manageTagService.addManageTag(manageTagAddDTO);
        return ResponseBo.ok("添加成功!");
    }

    @ApiOperation(value="修改标签信息", notes="")
    @PostMapping("/edit")
    public ResponseBo editManageTag(@RequestBody ManageTagEditDTO manageTagEditDTO){
        this.manageTagService.editManageTag(manageTagEditDTO);
        return ResponseBo.ok("修改成功!");
    }

    @ApiOperation(value="删除标签信息", notes="")
    @PostMapping("/delete")
    public ResponseBo deleteManageTagByTagId(@RequestBody ManageTagIdDTO manageTagIdDTO){
        this.manageTagService.deleteManageTagByTagId(manageTagIdDTO);
        return ResponseBo.ok("删除成功!");
    }

    @ApiOperation(value="启用标签信息", notes="")
    @PostMapping("/enable")
    public ResponseBo enableManageTagByTagId(@RequestBody ManageTagIdDTO manageTagIdDTO){
        this.manageTagService.enableManageTagByTagId(manageTagIdDTO);
        return ResponseBo.ok("启用成功!");
    }

    @ApiOperation(value="停用标签信息", notes="")
    @PostMapping("/disable")
    public ResponseBo disableManageTagByTagId(@RequestBody ManageTagIdDTO manageTagIdDTO){
        this.manageTagService.disableManageTagByTagId(manageTagIdDTO);
        return ResponseBo.ok("停用成功!");
    }

    @ApiOperation(value="test", notes="")
    @PostMapping("/test")
    public ResponseBo test(){
        this.manageTagService.parent();
        this.manageTagService.child();
        return ResponseBo.ok("test");
    }
}
