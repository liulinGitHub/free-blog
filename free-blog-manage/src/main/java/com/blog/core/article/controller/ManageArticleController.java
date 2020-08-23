package com.blog.core.article.controller;

import com.blog.core.article.service.ManageArticleService;
import com.blog.core.common.utils.BaseController;
import com.blog.core.common.utils.QueryRequest;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ManageArticleController
 * @description: 文章信息服务Controller
 * @author: 950103
 * @create: 2019-11-22 14:46
 * @version: 1.0
 */
@Api(value = "文章信息服务Controller",tags = "文章信息服务")
@RestController
@RequestMapping("/article")
public class ManageArticleController extends BaseController {

    @Autowired
    private ManageArticleService manageArticleService;

    @ApiOperation(value="分页查询文章信息", notes="")
    @PostMapping("/all")
    public ResponseBo queryManageArticleByPage(QueryRequest queryRequest){
        return ResponseBo.newDataResponse(super.selectByPageNumSize(queryRequest, () ->
                this.manageArticleService.queryManageArticleByPage()));
    }

    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/details")
    public ResponseBo queryManageArticleDetails(@PathVariable String articleId){
        return ResponseBo.newDataResponse(this.manageArticleService.queryManageArticleByArticleId(articleId));
    }

    @ApiOperation(value="文章审核通过", notes="")
    @PutMapping("/check_article")
    public ResponseBo checkManageArticle(String articleId){
        this.manageArticleService.checkManageArticle(articleId);
        return ResponseBo.ok("文章审核通过");
    }
}
