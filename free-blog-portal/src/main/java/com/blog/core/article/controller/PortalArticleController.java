package com.blog.core.article.controller;

import com.blog.core.article.entity.dto.PortalArticleCheckDTO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: free-blog
 * @description: 文章信息服务Controller
 * @author: liulin
 * @create: 2019-04-29 17:32
 */
@Api(value = "文章信息服务Controller",tags = "文章信息服务")
@RestController
@RequestMapping("/portal/article")
public class PortalArticleController {

    @Autowired
    private PortalArticleService portalArticleService;

    @LogPortal("分页查询文章信息")
    @ApiOperation(value="分页查询文章信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryArticleByPage(){
        return ResponseBo.newDataResponse(this.portalArticleService.queryArticleByPage());
    }

    @LogPortal("查看文章详细信息")
    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/{id}")
    public ResponseBo findArticleById(@PathVariable String id){
        return ResponseBo.newDataResponse(this.portalArticleService.findArticleById(id));
    }

    @LogPortal("文章提交审核")
    @ApiOperation(value="文章提交审核", notes="")
    @PutMapping("/check_article")
    public ResponseBo submitCheckArticle(PortalArticleCheckDTO portalArticleCheckDTO){
        this.portalArticleService.submitCheckArticle(portalArticleCheckDTO);
        return ResponseBo.ok("提交成功！");
    }

    @LogPortal("文章保存草稿")
    @ApiOperation(value="文章保存草稿", notes="")
    @PutMapping("/save_draft")
    public ResponseBo saveDraft(PortalArticleCheckDTO portalArticleCheckDTO){
        this.portalArticleService.saveDraft(portalArticleCheckDTO);
        return ResponseBo.ok("保存草稿成功！");
    }

    @LogPortal("文章删除草稿")
    @ApiOperation(value="文章删除草稿", notes="")
    @DeleteMapping("/delete_draft")
    public ResponseBo deleteDraft(String articleId){
        this.portalArticleService.deleteDraft(articleId);
        return ResponseBo.ok("删除草稿！");
    }

    @LogPortal("文章热度")
    @ApiOperation(value="文章热度", notes="")
    @PutMapping("/update_temperature")
    public ResponseBo updateTemperature(String articleId){
        this.portalArticleService.updateTemperature(articleId);
        return ResponseBo.ok("文章已经升温！");
    }

//    @Log("文章审核")
//    @ApiOperation(value="文章审核通过", notes="")
//    @PutMapping("/article/check_article")
//    public ResponseBo checkArticle(String articleId){
//        this.articleService.checkArticle(articleId);
//        return ResponseBo.ok("文章审核通过");
//    }

    @LogPortal("文章点赞")
    @ApiOperation(value="文章点赞", notes="")
    @PutMapping("/update_approves")
    public ResponseBo updateApproves(String articleId){
        this.portalArticleService.updateApproves(articleId);
        return ResponseBo.ok("文章点赞通过");
    }

    @LogPortal("增加评论数")
    @ApiOperation(value="增加评论数", notes="")
    @PutMapping("/update_comments")
    public ResponseBo updateComments(String articleId){
        this.portalArticleService.updateComments(articleId);
        return ResponseBo.ok("添加加评论数通过");
    }
}
