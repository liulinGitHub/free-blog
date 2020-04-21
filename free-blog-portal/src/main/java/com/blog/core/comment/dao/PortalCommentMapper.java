package com.blog.core.comment.dao;


import com.blog.core.comment.entity.domain.PortalArticleComment;
import com.blog.core.comment.entity.vo.PortalArticleCommentVO;
import com.blog.core.comment.entity.vo.PortalCommentTree;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName: PortalCommentMapper
 * @Description: 评论信息Mapper
 * @Author: liulin
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
@Repository("portalCommentMapper")
public interface PortalCommentMapper {

    /**
     * 查询文章评论信息
     *
     * @param articleId
     * @return
     */
    List<PortalCommentTree> selectPortalCommentTree(String articleId);

    /**
     * 根据id查询评论信息
     *
     * @param commentId
     * @return
     */
    PortalArticleCommentVO queryCommentById(String commentId);

    /**
     * 根据文章id查询文章所有评论信息
     *
     * @param articleId
     * @return
     */
    List<PortalArticleCommentVO> queryCommentByArticleId(String articleId);

    /**
     * 根据父id查询评论信息
     *
     * @param parentId
     * @return
     */
    List<PortalArticleCommentVO> queryCommentByParentId(String parentId);

    /**
     * 保存评论信息
     *
     * @param portalArticleComment
     * @return
     */
    int insertComment(PortalArticleComment portalArticleComment);
}
