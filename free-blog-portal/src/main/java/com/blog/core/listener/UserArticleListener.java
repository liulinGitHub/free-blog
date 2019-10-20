package com.blog.core.listener;

import com.blog.core.common.exceptions.BlogRuntimeException;
import com.blog.core.event.UserArticleEvent;
import com.blog.core.system.user.dao.PortalUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

/**
 * @program: UserArticleListener
 * @description: 用户监听文章审核
 * @author: liulin
 * @create: 2019-05-27 16:20
 * @Version: 1.0
 */
@Slf4j
public class UserArticleListener {

    @Autowired
    private PortalUserMapper portalUserMapper;

    @EventListener
    public void onApplicationEvent(UserArticleEvent event) {
        String articleUserId = event.getSource();
        int results = this.portalUserMapper.updateArticleTotal(articleUserId);
        if(results < 1){
            log.error("增加用户文章数量失败【{}】", articleUserId);
            throw new BlogRuntimeException("审核失败！");
        }
    }
}
