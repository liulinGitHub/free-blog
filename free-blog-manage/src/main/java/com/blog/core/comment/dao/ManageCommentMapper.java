package com.blog.core.comment.dao;

import com.blog.core.comment.vo.ManageCommentDetailVO;
import com.blog.core.comment.vo.ManageCommentListVO;

import java.util.List;

/**
 * @program: ManageCommentMapper
 * @description:
 * @author: liulin
 * @create: 2019-12-19 09:44
 * @Version: 1.0
 */
public interface ManageCommentMapper {

    /**
     * 分页查询评论信息
     * @return
     */
    List<ManageCommentListVO> selectManageCommentByPage();

    /**
     * 根据评论id查询评论信息
     * @param commentId
     * @return
     */
    ManageCommentDetailVO selectManageCommentById(String commentId);
}
