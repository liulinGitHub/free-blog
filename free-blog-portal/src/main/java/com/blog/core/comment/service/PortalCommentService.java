package com.blog.core.comment.service;


import com.blog.core.comment.dto.PortalCommentAddDTO;
import com.blog.core.comment.vo.PortalCommentTree;
import com.blog.core.comment.vo.PortalCommentVO;

import java.util.List;

/**
 * @ClassName: PortalCommentService
 * @Description: 评论相关信息Service
 * @Author: 950103
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
public interface PortalCommentService {

    List<PortalCommentTree> queryPortalCommentTree(String articleId);

    /**
     * 根据父id查询评论信息
     * @param parentId
     * @return
     */
    List<PortalCommentVO> queryCommentByParentId(String parentId);

    /**
     * 保存评论信息
     * @param portalCommentAddDTO
     */
    void savePortalComment(PortalCommentAddDTO portalCommentAddDTO);

}
