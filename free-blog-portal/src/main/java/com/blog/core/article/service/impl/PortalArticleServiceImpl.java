package com.blog.core.article.service.impl;

import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.article.dto.PortalArticleCheckDTO;
import com.blog.core.article.entity.PortalArticle;
import com.blog.core.article.service.PortalArticleInfoService;
import com.blog.core.article.vo.PortalArticleDetailsVO;
import com.blog.core.article.vo.PortalArticleInfoVO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.article.vo.PortalArticleListVO;
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
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PortalArticleInfoService portalArticleInfoService;

    @Resource
    private PortalTagService portalTagService;

    @Override
    public List<PortalArticleListVO> queryArticleByPage() {
        List<PortalArticleListVO> portalArticleListVOList = this.portalArticleMapper.selectArticleByPage();
        if (CollectionUtils.isNotEmpty(portalArticleListVOList)) {
            portalArticleListVOList.parallelStream().forEach(portalArticleListVO -> {
                String articleId = portalArticleListVO.getArticleId();
                List<PortalTagVO> portalTagVOList = this.portalTagService.queryTagByArticleId(articleId);
                if (CollectionUtils.isNotEmpty(portalTagVOList)) {
                    portalArticleListVO.setTags(portalTagVOList);
                }
                PortalArticleInfoVO portalArticleInfoVO = this.portalArticleInfoService.queryPortalArticleInfoDetails(articleId);
                portalArticleListVO.setMeta(portalArticleInfoVO);
            });
        }
        return portalArticleListVOList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PortalArticleDetailsVO queryArticleDetails(String articleId) {
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
        // 增加一次访问量
        // this.portalArticleInfoService.updateReadArticleByArticleId(articleId);

        return portalArticleDetailsVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editArticleById(String articleId) {
        this.portalArticleMapper.selectArticleByArticleId(articleId);
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
        article.setArticleId(UUIDUtil.randomUUID32());
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
