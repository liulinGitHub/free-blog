package com.blog.core.comment.dao;


import com.blog.core.comment.entity.PortalComment;
import com.blog.core.comment.vo.PortalCommentTree;
import com.blog.core.comment.vo.PortalCommentVO;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ClassName: PortalCommentMapper
 * @Description: 评论信息Mapper
 * @Author: 950103
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
    List<PortalCommentTree> selectPortalCommentTree(Integer articleId);

    /**
     * 根据id查询评论信息
     *
     * @param commentId
     * @return
     */
    PortalCommentVO queryCommentById(Integer commentId);

    /**
     * 根据文章id查询文章所有评论信息
     *
     * @param articleId
     * @return
     */
    List<PortalCommentVO> queryCommentByArticleId(Integer articleId);

    /**
     * 根据父id查询评论信息
     *
     * @param parentId
     * @return
     */
    List<PortalCommentVO> queryCommentByParentId(Integer parentId);

    /**
     * 保存评论信息
     *
     * @param portalComment
     * @return
     */
    int insertPortalComment(PortalComment portalComment);
}
