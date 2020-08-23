package com.blog.core.article;

import com.blog.core.article.dao.PortalArticleMapper;
import com.blog.core.article.entity.PortalArticle;
import com.blog.core.article.service.PortalArticleService;
import com.blog.core.article.vo.PortalArticleListVO;
import com.blog.core.common.tread.TreadPoolConfig;
import com.blog.core.common.utils.MapperUtils;
import com.blog.core.common.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: PortalArticleServiceImplTest
 * @Description: 文章信息测试类
 * @date: 2020/8/22 0:38
 * @author: 950103
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalArticleServiceImplTest {

    @Autowired
    private PortalArticleService portalArticleService;

    @Autowired
    private PortalArticleMapper portalArticleMapper;

    @Test
    public void queryPortalArticleByPage() {
        long s1 = System.currentTimeMillis();
        List<PortalArticleListVO> list = this.portalArticleService.queryPortalArticleByPage();
        long s2 = System.currentTimeMillis();
        System.out.println(s2 - s1);
//        ThreadPoolExecutor pool = TreadPoolConfig.getPool();
//        for (int i = 0; i < 1000000; i++) {
//
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    addPortalArticle();
//                }
//            };
//            pool.execute(runnable);
//        }
//        pool.shutdown();

    }

    @Test
    public void addPortalArticle() {
        List<PortalArticleListVO> portalArticleListVOList = this.portalArticleService.queryPortalArticleByPage();
        List<PortalArticle> portalArticles = MapperUtils.mapperList(portalArticleListVOList, PortalArticle.class);
        portalArticles.parallelStream().forEach(portalArticle -> {
            portalArticle.setArticleId(UUIDUtil.randomUUID32());
            portalArticle.setArticleTitle(portalArticle.getArticleTitle());
            portalArticle.setReleaseStatus("1");
            portalArticleMapper.insert(portalArticle);
        });
    }
}
