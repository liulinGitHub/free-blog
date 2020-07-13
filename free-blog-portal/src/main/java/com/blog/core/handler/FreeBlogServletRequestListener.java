package com.blog.core.handler;

import com.blog.core.common.consts.RedisKeyConst;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: FreeBlogServletRequestListener
 * @Description:
 * @date: 2020/7/11 22:49
 * @author: 950103
 * @Version 1.0
 */
@Component
public class FreeBlogServletRequestListener implements ServletRequestListener {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = request.getSession();
        String ip = (String) session.getAttribute("ip");
        String ipAddr = IPUtils.getIpAddr(request);
//        if (!ipAddr.equals(ip)) {
//            session.setAttribute("ip", ipAddr);
//            redisUtil.lRightPush(RedisKeyConst.PORTAL_VISIT_IP_KEY, ipAddr);
//            redisUtil.incrBy(RedisKeyConst.PORTAL_VIEWS_COUNT, 1);
//        }
    }
}
