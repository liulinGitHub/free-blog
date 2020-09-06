package com.blog.core.comment.controller;

import com.blog.core.comment.dto.ManageCommentAddDTO;
import com.blog.core.comment.service.ManageCommentService;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 文章评论服务Controller
 * @author: 950103
 * @create: 2019-12-16 15:28
 * @Version: 1.0
 */
@Api(value = "文章评论服务Controller",tags = "文章评论服务")
@RestController
@RequestMapping("/comment")
public class ManageCommentController extends BaseController {

    @Autowired
    private ManageCommentService manageCommentService;

    @ApiOperation(value="分页查询文章评论信息", notes="")
    @PostMapping("/all")
    public ResponseBo queryManageCommentByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () -> this.manageCommentService.queryManageCommentByPage()));
    }

    @ApiOperation(value="查询评论信息", notes="")
    @GetMapping("/details")
    public ResponseBo queryManageCommentDetails(String commentId){
        return ResponseBo.newDataResponse(this.manageCommentService.queryManageCommentDetails(commentId));
    }

    @ApiOperation(value="添加评论信息", notes="")
    @PostMapping("/add")
    public ResponseBo addManageComment(@RequestBody ManageCommentAddDTO manageCommentAddDTO){
        this.manageCommentService.addManageComment(manageCommentAddDTO);
        return ResponseBo.ok("添加成功！");
    }

    @ApiOperation(value="评论点赞", notes="")
    @GetMapping("/approves")
    public ResponseBo addManageCommentApproves(String commentId){
        this.manageCommentService.addManageCommentApproves(commentId);
        return ResponseBo.ok("点赞成功！");
    }
}
