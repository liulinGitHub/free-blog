package com.blog.core.article.service.impl;

import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.article.domain.PortalArticle;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.articlecategory.service.PortalArticleCategoryService;
import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.ArticleStatusEnum;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.tag.entity.vo.PortalTagVO;
import com.blog.core.tag.service.PortalTagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service("portalArticleService")
public class PortalArticleServiceImpl implements PortalArticleService {

    @Resource
    private PortalArticleMapper portalArticleMapper;

    @Resource
    private PortalArticleCategoryService categoryService;

    @Resource
    private PortalTagService portalTagService;

    @Override
    public List<PortalArticleInfoVO> queryArticleByPage() {
        List<PortalArticleInfoVO> portalArticleInfoVOList = this.portalArticleMapper.selectArticleByPage();
        if (CollectionUtils.isNotEmpty(portalArticleInfoVOList)) {
            portalArticleInfoVOList.parallelStream().forEach(portalArticleInfoVO -> {
                List<PortalTagVO> portalTagVOList = this.portalTagService.queryTagByArticleId(portalArticleInfoVO.getId());
                if (CollectionUtils.isNotEmpty(portalTagVOList)) {
                    portalArticleInfoVO.setPortalTagVOList(portalTagVOList);
                }
            });
        }
        return portalArticleInfoVOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PortalArticleInfoVO findArticleById(String articleId) {
        //增加一次访问量
        this.portalArticleMapper.updateReadArticle(articleId);
        //文章信息
        PortalArticleInfoVO portalArticleInfoVO = this.portalArticleMapper.findArticleById(articleId);
        if (Objects.isNull(portalArticleInfoVO)) {
            return null;
        }
        List<PortalTagVO> portalTagVOList = this.portalTagService.queryTagByArticleId(portalArticleInfoVO.getId());
        if (CollectionUtils.isNotEmpty(portalTagVOList)) {
            portalArticleInfoVO.setPortalTagVOList(portalTagVOList);
        }

//        PortalArticleInfoVO sysBaseArticleInfoVO = new PortalArticleInfoVO();
//        if (StringUtils.isNotEmpty(articleVO.getCategoryId())) {
//            //文章分类信息
//            CategoryVO categoryVO = this.categoryService.findCategoryById(articleVO.getCategoryId());
//            sysBaseArticleInfoVO.setCategoryVO(categoryVO);
//        }

 /*     if(StringUtils.isNotEmpty(articleVO.getArticleUserId())){
            //文章用户信息
            SysBaseUserVO userVO = this.userMapper.selectUserById(articleVO.getArticleUserId());
            if(userVO != null){
                sysBaseArticleInfoVO.setArticleUserVO(userVO);
            }
        }*/
        // sysBaseArticleInfoVO.setArticleVO(articleVO);

        return portalArticleInfoVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editArticleById(String articleId) {
        this.portalArticleMapper.updateArticleById(articleId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void submitCheckArticle(PortalArticleCheckDTO portalArticleCheckDTO) {
        PortalArticle article = MapperUtils.mapperBean(portalArticleCheckDTO, PortalArticle.class);
        article.setArticleStatus(ArticleStatusEnum.REVIEW_YES.getValue());
        article.setArticleUserId(RequestHolder.get().toString());
        int result = this.portalArticleMapper.submitCheckArticle(article);
        if (result < 1) {
            log.error("提交文章审核失败!");
            throw new BlogRuntimeException("提交文章审核失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDraft(PortalArticleCheckDTO portalArticleCheckDTO) {
        PortalArticle article = MapperUtils.mapperBean(portalArticleCheckDTO, PortalArticle.class);
        article.setArticleTitleId(UUIDUtil.randomUUID32());
        article.setCreateTime(new Date());
        article.setArticleStatus(ArticleStatusEnum.DRAFT.getValue());
        int result = this.portalArticleMapper.saveDraft(article);
        if (result < 1) {
            log.error("保存文章草稿失败!");
            throw new BlogRuntimeException("保存文章草稿失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteDraft(String articleId) {
        int result = this.portalArticleMapper.deleteDraft(articleId);
        if (result < 1) {
            log.error("删除失败【{}】", articleId);
            throw new BlogRuntimeException("删除文章草稿失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApproves(String articleId) {
        int result = this.portalArticleMapper.updateApproves(articleId);
        if (result < 1) {
            log.error("文章点赞失败【{}】", articleId);
            throw new BlogRuntimeException("点赞失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateComments(String articleId) {
        int result = this.portalArticleMapper.updateComments(articleId);
        if (result < 1) {
            log.error("增加评论失败【{}】", articleId);
            throw new BlogRuntimeException("评论失败！");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTemperature(String articleId) {
        int result = this.portalArticleMapper.updateTemperature(articleId);
        if (result < 1) {
            log.error("文章升温失败【{}】", articleId);
            throw new BlogRuntimeException("文章升温失败！");
        }
    }
}
