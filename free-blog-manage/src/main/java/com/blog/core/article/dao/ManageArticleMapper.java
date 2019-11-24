package com.blog.core.article.dao;


import com.blog.core.article.entity.domain.ManageArticle;
import com.blog.core.article.entity.vo.ManageArticleInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: ManageArticleMapper
 * @description:
 * @author: liulin
 * @create: 2019-11-22 17:15
 * @Version: 1.0
 */
@Repository("manageArticleMapper")
public interface ManageArticleMapper {

    /**
     * 查询文章信息
     *
     * @return
     */
    List<ManageArticleInfoVO> selectArticleByPage();

    /**
     * 查看文章信息
     *
     * @param articleId
     * @return
     */
    ManageArticleInfoVO selectArticleByArticleId(String articleId);

    /**
     * 文章审核
     *
     * @param article
     * @return
     */
    int checkArticle(ManageArticle article);

}
