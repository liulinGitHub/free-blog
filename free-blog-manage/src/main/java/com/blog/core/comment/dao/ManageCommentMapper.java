package com.blog.core.comment.dao;

import com.blog.core.comment.entity.ManageComment;
import com.blog.core.comment.vo.ManageCommentDetailVO;
import com.blog.core.comment.vo.ManageCommentListVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: ManageCommentMapper
 * @description:
 * @author: 950103
 * @create: 2019-12-19 09:44
 * @Version: 1.0
 */
@Repository("manageCommentMapper")
public interface ManageCommentMapper {

    /**
     * 分页查询评论信息
     * @return
     */
    List<ManageCommentListVO> selectManageCommentByPage();

    /**
     * 根据评论id查询评论信息
     * @param commentBelongId
     * @return
     */
    List<ManageCommentDetailVO> selectManageCommentById(String commentBelongId);

    /**
     * @Author ll
     * @Description 添加评论信息
     * @Date 2020/2/6 17:34
     * @Param [manageComment]
     * @return void
     **/
    void insertManageComment(ManageComment manageComment);
}
