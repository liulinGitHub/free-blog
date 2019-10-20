package com.blog.core.comment.dao;


import com.blog.core.comment.entity.domain.PortalArticleComment;
import com.blog.core.comment.entity.vo.PortalArticleCommentVO;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository("portalCommentMapper")
public interface PortalCommentMapper {

    /**
     * 分页查询评论信息
     * @return
     */
    List<PortalArticleCommentVO> selectCommentByPage();

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
