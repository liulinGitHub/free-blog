package com.blog.core.article.service.impl;

import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.article.entity.domain.PortalArticle;
import com.blog.core.article.entity.dto.PortalArticleCheckDTO;
import com.blog.core.article.entity.vo.PortalArticleInfoVO;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.articlecategory.service.PortalArticleCategoryService;
import com.blog.core.common.aspect.RequestHolder;
import com.blog.core.common.enums.ArticleStatusEnum;
import com.blog.core.common.enums.ReleaseStatusEnum;
import com.blog.core.common.event.CommonEventPublisher;
import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import com.blog.core.event.UserArticleEvent;
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
    private CommonEventPublisher publisher;

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


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitCheckArticle(PortalArticleCheckDTO portalArticleCheckDTO) {
        PortalArticle article = MapperUtils.mapperBean(portalArticleCheckDTO, PortalArticle.class);
        article.setArticleStatus(ArticleStatusEnum.CHECK_NO.getValue());
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
        article.setId(UUIDUtil.randomUUID32());
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
    public void checkArticle(String articleId) {
        //审核文章，文章状态为已审核，发布状态为已发布
        PortalArticle article = new PortalArticle();
        article.setId(articleId);
        article.setArticleStatus(ArticleStatusEnum.CHECK_YES.getValue());
        article.setReleaseStatus(ReleaseStatusEnum.RELEASE_YES.getValue());
        article.setReleaseDate(new Date());
        int result = this.portalArticleMapper.checkArticle(article);
        if (result < 1) {
            log.error("审核失败【{}】", articleId);
            throw new BlogRuntimeException("审核文章失败！");
        }
        //文章审核成功。增加一次用户作者的文章数量
        PortalArticleInfoVO portalArticleInfoVO = this.portalArticleMapper.findArticleById(articleId);
        //修改用户信息后置事件
        publisher.publish(new UserArticleEvent(portalArticleInfoVO.getArticleUserId()));
        //发送消息給文章作者
        //******************
//        try {
//            WebSocketServer.sendInfo(article.getArticleUserId(),"我是后台消息");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
