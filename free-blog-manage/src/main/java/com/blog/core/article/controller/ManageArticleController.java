package com.blog.core.article.controller;

import com.blog.core.article.service.ManageArticleService;
import com.blog.core.common.annotation.LogManage;
import com.blog.core.common.utils.ResponseBo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ManageArticleController
 * @description: 文章信息服务Controller
 * @author: liulin
 * @create: 2019-11-22 14:46
 * @Version: 1.0
 */
@Api(value = "文章信息服务Controller",tags = "文章信息服务")
@RestController
@RequestMapping("/article")
public class ManageArticleController {

    @Autowired
    private ManageArticleService manageArticleService;

    @LogManage("分页查询文章信息")
    @ApiOperation(value="分页查询文章信息", notes="")
    @PostMapping("/query")
    public ResponseBo queryArticleByPage(){
        return ResponseBo.newDataResponse(this.manageArticleService.queryArticleByPage());
    }

    @LogManage("查看文章详细信息")
    @ApiOperation(value="查看文章详细信息", notes="")
    @GetMapping("/{articleId}")
    public ResponseBo queryArticleByArticleId(@PathVariable String articleId){
        return ResponseBo.newDataResponse(this.manageArticleService.queryArticleByArticleId(articleId));
    }

    @LogManage("文章审核")
    @ApiOperation(value="文章审核通过", notes="")
    @PutMapping("/article/check_article")
    public ResponseBo checkArticle(String articleId){
        this.manageArticleService.checkArticle(articleId);
        return ResponseBo.ok("文章审核通过");
    }
}
