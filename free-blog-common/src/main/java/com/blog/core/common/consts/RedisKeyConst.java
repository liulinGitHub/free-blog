package com.blog.core.common.consts;

/**
 * @ClassName: RedisKeyConst
 * @description: redis的key
 * @author: 950103
 * @create: 2019-06-15 09:24
 * @Version: 1.0
 */
public interface RedisKeyConst {

    /**
     * ID
     **/
    String PIMARY_KEY = "PIMARY_KEY";

    /**
     * 主键ID集合
     **/
    String PIMARY_KEY_LIST = "PIMARY_KEY_LIST";

    /**
     * 在线用户key
     **/
    String ONLINE_USER_ID_KEY = "ONLINE_USER_ID";

    /**
     * 前台访问IP KEY
     */
    String PORTAL_VISIT_IP_KEY = "PORTAL_VISIT_IP";

    /**
     * 前台访问人数 KEY
     */
    String PORTAL_VIEWS_COUNT = "PORTAL_VIEWS_COUNT";

    String CAPTCHA_KEY = "CAPTCHA_KEY";
}
