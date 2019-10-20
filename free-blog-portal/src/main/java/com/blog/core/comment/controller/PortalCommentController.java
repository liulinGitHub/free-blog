package com.blog.core.comment.controller;


import com.blog.core.comment.entity.dto.PortalArticleCommentAddDTO;
import com.blog.core.comment.service.PortalCommentService;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: free-blog
 * @description: 文章评论服务Controller
 * @author: liulin
 * @create: 2019-04-29 17:32
 */
@Api(value = "文章评论服务Controller",tags = "文章评论服务")
@RestController
@RequestMapping("/portal/comment")
public class PortalCommentController {

    @Autowired
    private PortalCommentService portalCommentService;

    @LogPortal("分页查询文章评论信息")
    @ApiOperation(value="分页查询文章评论信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryCommentByPage(){
        return ResponseBo.newDataResponse(this.portalCommentService.queryArticleCommentByPage());
    }

    @LogPortal("分页查询文章评论信息")
    @ApiOperation(value="分页查询文章评论信息", notes="")
    @GetMapping("/querybyarticleId")
    public ResponseBo queryCommentByArticleId(String articleId){
        return ResponseBo.newDataResponse(this.portalCommentService.queryCommentByArticleId(articleId));
    }

    @LogPortal("添加文章分类信息")
    @ApiOperation(value="添加文章分类信息", notes="")
    @PostMapping("/save")
    public ResponseBo saveArticleComment(@RequestBody PortalArticleCommentAddDTO portalArticleCommentAddDTO){
        this.portalCommentService.saveArticleComment(portalArticleCommentAddDTO);
        return ResponseBo.ok("添加成功！");
    }
}
