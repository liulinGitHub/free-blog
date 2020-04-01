package com.blog.core.article.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.article.service.ManageArticleService;
import com.blog.core.article.vo.ManageArticleListVO;
import com.blog.core.article.vo.ManageArticleVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ManageArticleServiceImplTest {

    @Autowired
    private ManageArticleService manageArticleService;

    @Test
    public void queryManageArticleByPage() {
        List<ManageArticleListVO> manageArticleListVOList = this.manageArticleService.queryManageArticleByPage();
        System.out.println(JSONObject.toJSONString(manageArticleListVOList));
    }

    @Test
    public void queryManageArticleByArticleId() {
        String articleId = "1";
        ManageArticleVO manageArticleVO = this.manageArticleService.queryManageArticleByArticleId(articleId);
        System.out.println(JSONObject.toJSONString(manageArticleVO));
    }
}
