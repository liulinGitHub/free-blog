package com.blog.core.article.controller;

import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.service.PortalArticleService;
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
 * @description: 文章信息服务Controller
 * @author: liulin
 * @create: 2019-04-29 17:32
 */
@Api(value = "文章信息服务Controller",tags = "文章信息服务")
@RestController
@RequestMapping("/article")
public class PortalArticleController extends BaseController {

    @Autowired
    private PortalArticleService portalArticleService;

    @ApiOperation(value="分页查询文章信息", notes="")
    @GetMapping("/query")
    public ResponseBo queryArticleByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () ->
                this.portalArticleService.queryArticleByPage()));
    }

    @LogPortal
    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/details/{articleId}")
    public ResponseBo queryArticleDetails(@PathVariable String articleId){
        return ResponseBo.newDataResponse(this.portalArticleService.queryArticleDetails(articleId));
    }

    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/edit/{articleId}")
    public ResponseBo editArticleById(@PathVariable String articleId){
        this.portalArticleService.editArticleById(articleId);
        return ResponseBo.ok("编辑成功！");
    }

    @ApiOperation(value="文章提交审核", notes="")
    @PutMapping("/check_article")
    public ResponseBo submitCheckArticle(PortalArticleCheckDTO portalArticleCheckDTO){
        this.portalArticleService.submitCheckArticle(portalArticleCheckDTO);
        return ResponseBo.ok("提交成功！");
    }

    @ApiOperation(value="文章保存草稿", notes="")
    @PutMapping("/save_draft")
    public ResponseBo saveDraft(PortalArticleCheckDTO portalArticleCheckDTO){
        this.portalArticleService.saveDraft(portalArticleCheckDTO);
        return ResponseBo.ok("保存草稿成功！");
    }

    @ApiOperation(value="文章删除草稿", notes="")
    @DeleteMapping("/delete_draft")
    public ResponseBo deleteDraft(String articleId){
        this.portalArticleService.deleteDraft(articleId);
        return ResponseBo.ok("删除草稿！");
    }

    @ApiOperation(value="文章热度", notes="")
    @PutMapping("/update_temperature")
    public ResponseBo updateTemperature(String articleId){
        this.portalArticleService.updateTemperature(articleId);
        return ResponseBo.ok("文章已经升温！");
    }

    @ApiOperation(value="文章点赞", notes="")
    @PutMapping("/update_approves")
    public ResponseBo updateApproves(String articleId){
        this.portalArticleService.updateApproves(articleId);
        return ResponseBo.ok("文章点赞通过");
    }

    @ApiOperation(value="增加评论数", notes="")
    @PutMapping("/update_comments")
    public ResponseBo updateComments(String articleId){
        this.portalArticleService.updateComments(articleId);
        return ResponseBo.ok("添加加评论数通过");
    }
}
