package com.blog.core.article.service.impl;

import com.blog.core.article.dao.ManageArticleMapper;
import com.blog.core.article.entity.ManageArticle;
import com.blog.core.article.service.ManageArticleService;
import com.blog.core.article.vo.ManageArticleListVO;
import com.blog.core.article.vo.ManageArticleVO;
import com.blog.core.common.enums.ArticleStatusEnum;
import com.blog.core.common.enums.ReleaseStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: ManageArticleServiceImpl
 * @description:
 * @author: liulin
 * @create: 2019-11-22 14:53
 * @Version: 1.0
 */
@Service("manageArticleService")
public class ManageArticleServiceImpl implements ManageArticleService {

    @Autowired
    private ManageArticleMapper manageArticleMapper;

    @Override
    public List<ManageArticleListVO> queryManageArticleByPage() {
        List<ManageArticleListVO> manageArticleListVOList = this.manageArticleMapper.selectManageArticleByPage();
        return manageArticleListVOList;
    }

    @Override
    public ManageArticleVO queryManageArticleByArticleId(String articleId) {
        ManageArticleVO manageArticleVO = this.manageArticleMapper.selectManageArticleByArticleId(articleId);
        return manageArticleVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void checkManageArticle(String articleId) {
        //审核文章，文章状态为已审核，发布状态为已发布
        ManageArticle manageArticle = new ManageArticle();
        manageArticle.setArticleId(articleId);
        manageArticle.setArticleStatus(ArticleStatusEnum.REVIEW_YES);
        manageArticle.setReleaseStatus(ReleaseStatusEnum.RELEASE_YES);
        manageArticle.setReleaseDate(new Date());
        this.manageArticleMapper.checkArticle(manageArticle);

        //文章审核成功。增加一次用户作者的文章数量
        //ManageArticleInfoVO portalArticleInfoVO = this.manageArticleMapper.selectArticleByArticleId(articleId);
        //修改用户信息

        //发送消息給文章作者
        //************************************************************
//        try {
//            WebSocketServer.sendInfo(article.getArticleUserId(),"我是后台消息");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
