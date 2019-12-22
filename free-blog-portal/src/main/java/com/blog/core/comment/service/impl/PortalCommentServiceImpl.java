package com.blog.core.comment.service.impl;

import com.blog.core.comment.dao.PortalCommentMapper;
import com.blog.core.comment.entity.domain.PortalArticleComment;
import com.blog.core.comment.entity.dto.PortalArticleCommentAddDTO;
import com.blog.core.comment.entity.vo.PortalArticleCommentVO;
import com.blog.core.comment.service.PortalCommentService;
import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.IsEnableEnum;
import com.blog.core.common.enums.IsParentEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service("portalCommentService")
public class PortalCommentServiceImpl implements PortalCommentService {

    @Autowired
    private PortalCommentMapper portalCommentMapper;

    @Override
    public List<PortalArticleCommentVO> queryArticleCommentByPage() {
        List<PortalArticleCommentVO> portalArticleCommentVOList = this.portalCommentMapper.selectCommentByPage();
        return portalArticleCommentVOList;
    }

    @Override
    public PortalArticleCommentVO queryCommentById(String commentId) {
        PortalArticleCommentVO portalArticleCommentVO = this.portalCommentMapper.queryCommentById(commentId);
        return portalArticleCommentVO;
    }

    @Override
    public List<PortalArticleCommentVO> queryCommentByParentId(String parentId) {
        List<PortalArticleCommentVO> portalArticleCommentVOList = this.portalCommentMapper.queryCommentByParentId(parentId);
        return portalArticleCommentVOList;
    }

    @Override
    public List<PortalArticleCommentVO> queryCommentByArticleId(String articleId) {
        List<PortalArticleCommentVO> portalArticleCommentVOList = this.portalCommentMapper.queryCommentByArticleId(articleId);
        if (CollectionUtils.isNotEmpty(portalArticleCommentVOList)) {
            portalArticleCommentVOList.forEach(portalArticleCommentVO -> {
                List<PortalArticleCommentVO> portalArticleCommentVOS = this.queryCommentByParentId(portalArticleCommentVO.getId());
                if (CollectionUtils.isNotEmpty(portalArticleCommentVOS)) {
                    portalArticleCommentVO.setArticleCommentVOList(portalArticleCommentVOS);
                }
            });
        }
        return portalArticleCommentVOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArticleComment(PortalArticleCommentAddDTO portalCommentAddDTO) {
        PortalArticleComment portalArticleComment = MapperUtils.mapperBean(portalCommentAddDTO, PortalArticleComment.class);
        portalArticleComment.setId(UUIDUtil.randomUUID32());
        portalArticleComment.setCommentUserId(RequestHolder.get()+"");
        portalArticleComment.setCommentTime(new Date());
        portalArticleComment.setIsEnable(IsEnableEnum.Enable_NO.getValue());
        portalArticleComment.setArticleId(portalCommentAddDTO.getArticleId());
        if(Objects.nonNull(portalArticleComment.getParentId())){
            portalArticleComment.setParentId(portalArticleComment.getParentId());
            portalArticleComment.setIsParent(IsParentEnum.PARENT_NO.getValue());
        }else {
            portalArticleComment.setParentId("0");
            portalArticleComment.setIsParent(IsParentEnum.PARENT_YES.getValue());
        }
        int result = this.portalCommentMapper.insertComment(portalArticleComment);
        if (result < 1) {
            log.error("评论失败!【{}】", "commentUserId");
            throw new BlogRuntimeException("评论失败！");
        }
        //增加文章评论数 后置事件
        //this.articleService.updateComments(articleId);
        //publisher.publish(new ArticleEvent(articleId));
    }
}
