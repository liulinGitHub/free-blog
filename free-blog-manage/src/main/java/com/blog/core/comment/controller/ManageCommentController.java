package com.blog.core.comment.controller;

import com.blog.core.comment.dto.ManageCommentAddDTO;
import com.blog.core.comment.service.ManageCommentService;
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
 * @program: CommentController
 * @description: 文章评论服务Controller
 * @author: liulin
 * @create: 2019-12-16 15:28
 * @Version: 1.0
 */
@Api(value = "文章评论服务Controller",tags = "文章评论服务")
@RestController
@RequestMapping("/comment")
public class ManageCommentController extends BaseController {

    @Autowired
    private ManageCommentService manageCommentService;

    @LogManage("分页查询文章评论信息")
    @ApiOperation(value="分页查询文章评论信息", notes="")
    @PostMapping("/query")
    public ResponseBo queryManageCommentByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageCommentService.queryManageCommentByPage()));
    }

    @LogPortal("分页查询文章评论信息")
    @ApiOperation(value="分页查询文章评论信息", notes="")
    @GetMapping("/querybyarticleId")
    public ResponseBo queryManageCommentByArticleId(String articleId){
        return ResponseBo.newDataResponse(this.manageCommentService.queryManageCommentByArticleId(articleId));
    }

    @LogPortal("添加文章分类信息")
    @ApiOperation(value="添加文章分类信息", notes="")
    @PostMapping("/save")
    public ResponseBo saveManageComment(@RequestBody ManageCommentAddDTO manageCommentAddDTO){
        this.manageCommentService.saveManageComment(manageCommentAddDTO);
        return ResponseBo.ok("添加成功！");
    }
}
