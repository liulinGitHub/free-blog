package com.blog.core.timedtask;

import com.blog.core.common.consts.Constants;
import com.blog.core.common.consts.RedisKeyConst;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.PrimarykeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 定时生成主键ID
 * @Author: 950103
 * @Date: 2020/4/4 20:26
 * @version: 1.0
 **/
@Slf4j
@Component
@EnableScheduling
public class BuildTimedJob {

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Autowired
    private RedisUtil redisUtil;

    //@Scheduled(cron = "0 0 */1 * * ?")
    public void buildPrimarykey() {
        log.info("定时补充主键ID");
        long primarykeySize = redisUtil.sSize(RedisKeyConst.PIMARY_KEY_LIST);
        if (primarykeySize == 0) {
            log.info("初始化定时补充主键ID");
            this.initPrimarykey();
        } else if (primarykeySize <= Constants.PRIMARY_WARN_VALUE) {
            log.info("redis中主键ID数量小于警戒值，补充主键ID");
            for (int i = 0; i < 100; i++) {
                String key = primarykeyUtil.generatePimaryKey();
                redisUtil.sAdd(RedisKeyConst.PIMARY_KEY_LIST, key);
            }
        }
    }

    public void initPrimarykey() {
        for (int i = 0; i < 100; i++) {
            String key = primarykeyUtil.generatePimaryKey();
            redisUtil.sAdd(RedisKeyConst.PIMARY_KEY_LIST, key);
        }
    }

//    private static int i = -1;
//    @Scheduled(cron = "*/10 * * * * ?")
//    public void test() {
//        i++;
//        System.out.println(i);
//    }
}
