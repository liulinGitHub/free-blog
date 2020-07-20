package com.blog.core.article.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.blog.core.approva.service.PortalApprovalService;
import com.blog.core.article.vo.PortalArticleApprovalVO;
import com.blog.core.common.enums.ApprovalTypeEnum;
import com.blog.core.system.user.vo.PortalUserApprovalVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PortalArticleApprovalServiceImplTest {

    @Autowired
    private PortalApprovalService portalArticleApprovalService;

    @Test
    public void approval() {
        for (int i = 1000; i < 1010; i++) {
            for (int j = 1; j < 10; j++) {
                PortalUserApprovalVO portalUserApprovalVO = new PortalUserApprovalVO();
                portalUserApprovalVO.setUserId(j + "");
                portalUserApprovalVO.setUserName("用户-" + j);
                portalUserApprovalVO.setNickName("用户昵称-" + j);
                portalUserApprovalVO.setAvatar("用户头像-" + j);
                portalArticleApprovalService.approval(ApprovalTypeEnum.APPROVAL_ARTICLE, i, j, portalUserApprovalVO);
            }
        }
    }

    @Test
    public void obtainApprovalCount() {
        portalArticleApprovalService.approval(ApprovalTypeEnum.APPROVAL_ARTICLE, 1001, 4, null);
        Long approvalCount = portalArticleApprovalService.obtainApprovalCount(ApprovalTypeEnum.APPROVAL_ARTICLE, 1001 + "");
        System.out.println(approvalCount);
    }

    @Test
    public void approval1() {
//        for (int j = 1; j <= 100; j++) {
//            PortalArticleApprovalVO article = new PortalArticleApprovalVO();
//            article.setArticleTitleId(j + "");
//            article.setArticleTitle("文章标题" + j);
//            article.setArticleImage("文章图片" + j);
//            // article.setSummary("文章摘要" + j);
//            for (int i = 1; i <= j; i++) {
//                PortalUserApprovalVO user = new PortalUserApprovalVO();
//                user.setUserId(i+"");
//                user.setUserName("用户" + i);
//                user.setNickName("昵称" + i);
//                user.setAvatar("头像" + i);
//                portalArticleApprovalService.approval(ApprovalTypeEnum.APPROVAL_ARTICLE, j, article, i, user);
//            }
//        }
//
        PortalArticleApprovalVO article = new PortalArticleApprovalVO();
        article.setArticleTitleId(10 + "");
        article.setArticleTitle("文章标题" + 10);
        article.setArticleImage("文章图片" + 10);

        PortalUserApprovalVO user = new PortalUserApprovalVO();
        user.setUserId(1001+"");
        user.setUserName("用户" + 1001);
        user.setNickName("昵称" + 1001);
        user.setAvatar("头像" + 1001);
        portalArticleApprovalService.approval(ApprovalTypeEnum.APPROVAL_ARTICLE, 10, article, 1001, user);
    }

    @Test
    public void obtainApprovalCount1() {
        System.out.println(portalArticleApprovalService.obtainApprovalCount(ApprovalTypeEnum.APPROVAL_ARTICLE, 100));
    }

    @Test
    public void obtainSubjectTopN() {
        Set<Object> set = this.portalArticleApprovalService.obtainSubjectTopN(ApprovalTypeEnum.APPROVAL_ARTICLE, 10L);
        for (Object o : set) {
            PortalArticleApprovalVO portalArticleApprovalVO = (PortalArticleApprovalVO) o;
            System.out.println(JSONObject.toJSONString(portalArticleApprovalVO));
        }
    }

    @Test
    public void getPostUserList() {
        List<Object> list = this.portalArticleApprovalService.getPostUserList(ApprovalTypeEnum.APPROVAL_ARTICLE, 100);
        for (Object o : list) {
            PortalUserApprovalVO portalUserApprovalVO = (PortalUserApprovalVO) o;
            System.out.println(JSONObject.toJSONString(portalUserApprovalVO));
        }
    }
}
