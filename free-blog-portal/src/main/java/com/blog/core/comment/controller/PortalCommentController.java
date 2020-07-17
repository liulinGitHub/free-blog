package com.blog.core.comment.controller;

import com.blog.core.comment.dto.PortalCommentAddDTO;
import com.blog.core.comment.service.PortalCommentService;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: PortalCommentController
 * @Dscription: 文章评论服务Controller
 * @Author: 950103
 * @Create: 2019-04-29 17:32
 */
@Api(value = "文章评论服务Controller",tags = "文章评论服务")
@RestController
@RequestMapping("/comment")
public class PortalCommentController {

    @Autowired
    private PortalCommentService portalCommentService;

    @ApiOperation(value="分页查询文章评论信息", notes="")
    @GetMapping("/query/{articleId}")
    public ResponseBo queryCommentByPage(@PathVariable String articleId){
        return ResponseBo.newDataResponse(this.portalCommentService.queryPortalCommentTree(articleId));
    }

    @ApiOperation(value="添加评论", notes="")
    @PostMapping("/save")
    public ResponseBo savePortalComment(@RequestBody PortalCommentAddDTO portalCommentAddDTO) {
        this.portalCommentService.savePortalComment(portalCommentAddDTO);
        return ResponseBo.ok("评论成功！");
    }
}
