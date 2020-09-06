package com.blog.core.article.service.impl;

import com.blog.core.approva.service.PortalApprovalService;
import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.article.dto.PortalArticleAddDTO;
import com.blog.core.article.dto.PortalArticleApprovalDTO;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.entity.PortalArticle;
import com.blog.core.article.service.PortalArticleInfoService;
import com.blog.core.article.vo.PortalArticleDetailsVO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.article.vo.PortalArticleListVO;
import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.consts.Constants;
import com.blog.core.common.enums.*;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.system.user.entity.PortalCommonUser;
import com.blog.core.system.user.service.PortalCommonUserService;
import com.blog.core.tag.vo.PortalTagVO;
import com.blog.core.tag.service.PortalTagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 文章信息service
 * @Author: 950103
 * @Date: 2020/3/25 11:08
 **/
@Slf4j
@Service
public class PortalArticleServiceImpl implements PortalArticleService {

    @Resource
    private PortalArticleMapper portalArticleMapper;

    @Autowired
    private PortalArticleInfoService portalArticleInfoService;

    @Autowired
    private PortalTagService portalTagService;

    @Autowired
    private PortalCommonUserService portalCommonUserService;

    @Autowired
    private PortalApprovalService portalApprovalService;

    /**
     * 可以考虑是否将文章的标签，点赞数，评论数，浏览数，文章用户信息放在redis当中
     *
     * @return
     */
    @Override
    public List<PortalArticleListVO> queryPortalArticleByPage() {
        List<PortalArticleListVO> portalArticleListVOList = this.portalArticleMapper.selectArticleByPage();
//        if (CollectionUtils.isNotEmpty(portalArticleListVOList)) {
//            portalArticleListVOList.parallelStream().forEach(portalArticleListVO -> {
//                String articleId = portalArticleListVO.getArticleId();
////                PortalArticleInfoVO meta = this.portalArticleInfoService.queryPortalArticleInfoDetails(articleId);
////                portalArticleListVO.setMeta(meta);
//
//                PortalCommonUser portalCommonUser = this.portalCommonUserService.queryPortalCommonUserByUserId(portalArticleListVO.getArticleUserId());
//                portalArticleListVO.setArticleUser(portalCommonUser);
//            });
//        }
        return portalArticleListVOList;
    }

    @Override
    public PortalArticleDetailsVO queryPortalArticleDetails(Integer articleId) {
        // 查询文章信息
        PortalArticleDetailsVO portalArticleDetailsVO = this.portalArticleMapper.selectArticleByArticleId(articleId);
        // 查询文章标签
        List<PortalTagVO> portalTagVOList = this.portalTagService.queryTagByArticleId(articleId);
        if (CollectionUtils.isNotEmpty(portalTagVOList)) {
            portalArticleDetailsVO.setTags(portalTagVOList);
        }
        // 查询文章相关信息
        PortalArticleInfoVO portalArticleInfoVO = this.portalArticleInfoService.queryPortalArticleInfoDetails(articleId);
        portalArticleDetailsVO.setMeta(portalArticleInfoVO);

        // 增加一次访问量
        // this.portalArticleInfoService.updateReadArticleByArticleId(articleId);

        return portalArticleDetailsVO;
    }

    @Transactional(rollbackFor = BlogRuntimeException.class)
    @Override
    public void savePortalArticleDraft(PortalArticleAddDTO portalArticleAddDTO) {
        PortalArticle portalArticle = MapperUtils.mapperBean(portalArticleAddDTO, PortalArticle.class);
        portalArticle.setCreateId(Constants.USER_ID);
        portalArticle.setCreateTime(new Date());
        portalArticle.setCommentStatus(ArticleCommentsStatusEnum.COMMENTS_YES.getValue());
        portalArticle.setTopStatus(TopStatusEnum.TOP_NO.getValue());
        portalArticle.setDraftStatus(DraftStatusEnum.DRAFT_NO.getValue());
        portalArticle.setAuditStatus(AuditStatusEnum.AUDIT_NO.getValue());
        portalArticle.setEnable(EnableEnum.Enable_YES.getValue());

        // TODO 修改xml文件
        this.portalArticleMapper.insertPortalArticleDraft(portalArticle);
    }

    @Transactional(rollbackFor = BlogRuntimeException.class)
    @Override
    public void submitCheckPortalArticle(PortalArticleCheckDTO portalArticleCheckDTO) {
        PortalArticle article = MapperUtils.mapperBean(portalArticleCheckDTO, PortalArticle.class);
        //article.setArticleUserId(RequestHolder.get());
        this.portalArticleMapper.submitCheckArticle(article);
    }

    @Override
    @Transactional
    public void deletePortalArticleDraft(Integer articleId) {
        this.portalArticleMapper.deletePortalArticleDraft(articleId, EnableEnum.Enable_NO);
    }

    @Override
    public void approvesPortalArticle(PortalArticleApprovalDTO portalArticleApprovalDTO) {
        PortalCommonUser portalCommonUser = this.portalCommonUserService.queryPortalCommonUserByUserId(portalArticleApprovalDTO.getPostUserId());
        this.portalApprovalService.approval(ApprovalTypeEnum.APPROVAL_ARTICLE,
                portalArticleApprovalDTO.getSubjectArticleId(),
                portalArticleApprovalDTO,
                portalArticleApprovalDTO.getPostUserId(),
                portalCommonUser);
    }

}
