package com.blog.core.comment.service.impl;

import com.blog.core.comment.dao.ManageCommentMapper;
import com.blog.core.comment.dto.ManageCommentAddDTO;
import com.blog.core.comment.vo.ManageCommentDetailVO;
import com.blog.core.comment.vo.ManageCommentListVO;
import com.blog.core.comment.service.ManageCommentService;
import com.blog.core.comment.vo.ManageCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ManageCommentServiceImpl
 * @description:
 * @author: liulin
 * @create: 2019-12-18 16:41
 * @Version: 1.0
 */
@Service
public class ManageCommentServiceImpl implements ManageCommentService {

    @Autowired
    private ManageCommentMapper manageCommentMapper;

    @Override
    public List<ManageCommentListVO> queryManageCommentByPage() {
        List<ManageCommentListVO> manageCommentVOList = this.manageCommentMapper.selectManageCommentByPage();
        return manageCommentVOList;
    }

    @Override
    public ManageCommentDetailVO queryManageCommentById(String commentId) {
        return this.manageCommentMapper.selectManageCommentById(commentId);
    }

    @Override
    public List<ManageCommentVO> queryManageCommentByParentId(String parentId) {
        return null;
    }

    @Override
    public List<ManageCommentVO> queryManageCommentByArticleId(String articleId) {
        return null;
    }

    @Override
    public void saveManageComment(ManageCommentAddDTO portalCommentAddDTO) {

    }
}
