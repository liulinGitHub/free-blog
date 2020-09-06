package com.blog.core.article.controller;

import com.blog.core.article.dto.PortalArticleAddDTO;
import com.blog.core.article.dto.PortalArticleApprovalDTO;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.article.vo.PortalArticleApprovalVO;
import com.blog.core.common.annotation.LogPortal;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName: PortalArticleController
 * @description: 文章信息服务Controller
 * @author: 950103
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
    public ResponseBo queryPortalArticleByPage(QueryRequest queryRequest) {
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () ->
                this.portalArticleService.queryPortalArticleByPage()));
    }

    @LogPortal
    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/details/{articleId}")
    public ResponseBo queryPortalArticleDetails(@PathVariable("articleId") Integer articleId) {
        return ResponseBo.newDataResponse(this.portalArticleService.queryPortalArticleDetails(articleId));
    }

    @ApiOperation(value="文章提交审核", notes="")
    @PutMapping("/check_article")
    public ResponseBo submitCheckPortalArticle(PortalArticleCheckDTO portalArticleCheckDTO) {
        this.portalArticleService.submitCheckPortalArticle(portalArticleCheckDTO);
        return ResponseBo.ok("提交成功！");
    }

    @ApiOperation(value="文章保存草稿", notes="")
    @PutMapping("/save/draft")
    public ResponseBo savePortalArticleDraft(@RequestBody @Valid PortalArticleAddDTO portalArticleAddDTO) {
        this.portalArticleService.savePortalArticleDraft(portalArticleAddDTO);
        return ResponseBo.ok("保存草稿成功！");
    }

    @ApiOperation(value="文章删除草稿", notes="")
    @DeleteMapping("/delete/draft/{articleId}")
    public ResponseBo deletePortalArticleDraft(@PathVariable("articleId") Integer articleId) {
        this.portalArticleService.deletePortalArticleDraft(articleId);
        return ResponseBo.ok("删除草稿！");
    }

    @ApiOperation(value="文章点赞", notes="")
    @PutMapping("/approves")
    public ResponseBo approvesPortalArticle(@RequestBody @Valid PortalArticleApprovalDTO portalArticleApprovalDTO) {
        this.portalArticleService.approvesPortalArticle(portalArticleApprovalDTO);
        return ResponseBo.ok("文章点赞通过");
    }
}
