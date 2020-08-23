package com.blog.core.article.service.impl;

import com.blog.core.article.dao.PortalArticleInfoMapper;
import com.blog.core.article.service.PortalArticleInfoService;
import com.blog.core.article.vo.PortalArticleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: PortalArticleInfoServiceImpl
 * @Description: 文章相关信息Service实现类
 * @Author: 950103
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
@Service
public class PortalArticleInfoServiceImpl implements PortalArticleInfoService {

    @Autowired
    private PortalArticleInfoMapper portalArticleInfoMapper;

    @Override
    public PortalArticleInfoVO queryPortalArticleInfoDetails(String articleId) {
        return this.portalArticleInfoMapper.selectPortalArticleInfoDetails(articleId);
    }

    @Override
    public void editArticleCommentNumber(String articleId) {
        this.portalArticleInfoMapper.updateArticleCommentNumber(articleId);
    }
}
