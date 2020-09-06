package com.blog.core.comment.service.impl;

import com.blog.core.approva.service.PortalApprovalService;
import com.blog.core.article.service.PortalArticleInfoService;
import com.blog.core.comment.dao.PortalCommentMapper;
import com.blog.core.comment.dto.PortalApprovalCommentDTO;
import com.blog.core.comment.dto.PortalCommentAddDTO;
import com.blog.core.comment.entity.PortalComment;
import com.blog.core.comment.vo.PortalCommentTree;
import com.blog.core.comment.service.PortalCommentService;
import com.blog.core.common.consts.Constants;
import com.blog.core.common.enums.ApprovalTypeEnum;
import com.blog.core.common.enums.EnableEnum;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.system.user.entity.PortalCommonUser;
import com.blog.core.system.user.service.PortalCommonUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName: PortalCommentServiceImpl
 * @Description: 评论相关信息Service实现类
 * @Author: 950103
 * @Date: 2020/4/19 21:14
 * @Version 1.0
 */
@Slf4j
@Service("portalCommentService")
public class PortalCommentServiceImpl implements PortalCommentService {

    @Autowired
    private PortalCommentMapper portalCommentMapper;

    @Autowired
    private PortalCommonUserService portalCommonUserService;

    @Autowired
    private PortalApprovalService portalApprovalService;

    @Autowired
    private PortalArticleInfoService portalArticleInfoService;

    @Override
    public List<PortalCommentTree> queryPortalCommentTree(Integer articleId) {
        List<PortalCommentTree> portalCommentTreeList = this.portalCommentMapper.selectPortalCommentTree(articleId);
        if (CollectionUtils.isEmpty(portalCommentTreeList)) {
            return new ArrayList<>();
        }
        List<PortalCommentTree> commentTreeList = portalCommentTreeList.stream()
                .filter(portalCommentTree -> Objects.nonNull(portalCommentTree.getParentId()))
                .collect(Collectors.toList());
        for (PortalCommentTree commentTree : commentTreeList) {
            List<PortalCommentTree> replyChildrenList = portalCommentTreeList.stream().filter(portalCommentTree ->
                    Objects.nonNull(portalCommentTree.getParentId())
                            && portalCommentTree.getParentId().equals(commentTree.getCommentId())
            ).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(replyChildrenList)) {
                for (PortalCommentTree replyChildrenTree : replyChildrenList) {
                    if (commentTree.getReplyChildren() == null) {
                        commentTree.setReplyChildren(new ArrayList<>());
                    }
                    commentTree.getReplyChildren().add(replyChildrenTree);
                }
            }
        }
        return commentTreeList;
    }

    @Transactional
    @Override
    public void  savePortalComment(PortalCommentAddDTO portalCommentAddDTO) {
        PortalComment portalComment = MapperUtils.mapperBean(portalCommentAddDTO, PortalComment.class);
        portalComment.setCommentUserId(Constants.USER_ID);
        portalComment.setCommentTime(new Date());
        portalComment.setEnable(EnableEnum.Enable_NO.getValue());
        portalComment.setArticleId(portalCommentAddDTO.getArticleId());
        if (Objects.nonNull(portalComment.getParentId())) {
            portalComment.setParentId(portalComment.getParentId());
        }
        portalComment.setApproves(0L);
        portalComment.setCreateId(Constants.USER_ID);
        portalComment.setCreateTime(new Date());
        this.portalCommentMapper.insertPortalComment(portalComment);
        //增加文章评论数 后置事件
        this.portalArticleInfoService.editArticleCommentNumber(portalCommentAddDTO.getArticleId());
    }

    @Override
    public void approvalPortalComment(PortalApprovalCommentDTO portalApprovalCommentDTO) {
        PortalCommonUser portalCommonUser = this.portalCommonUserService.queryPortalCommonUserByUserId(portalApprovalCommentDTO.getPostUserId());
        this.portalApprovalService.approval(ApprovalTypeEnum.APPROVAL_COMMENT,
                portalApprovalCommentDTO.getSubjectCommentId(),
                portalApprovalCommentDTO,
                portalApprovalCommentDTO.getPostUserId(),
                portalCommonUser);
    }
}
