package com.blog.core.article.dao;

import com.blog.core.article.vo.PortalArticleInfoVO;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: PortalArticleInfoMapper
 * @Description: 文章相关信息Mapper
 * @Author: liulin
 * @Date: 2020/4/19 21:20
 * @Version 1.0
 */
@Repository("portalArticleInfoMapper")
public interface PortalArticleInfoMapper {

    /**
     * 根据文章ID 查询文章相关信息
     *
     * @param articleId
     * @return PortalArticleInfoVO
     */
    PortalArticleInfoVO selectPortalArticleInfoDetails(String articleId);
}
