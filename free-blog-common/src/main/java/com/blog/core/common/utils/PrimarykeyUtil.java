package com.blog.core.common.utils;

import com.blog.core.common.consts.RedisKeyConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassNmae: PrimarkeyUtil
 * @description: 生成唯一的key
 * @Author: liulin
 * @Date: 2020/2/2 14:36
 **/
@Slf4j
@Component
public class PrimarykeyUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public String getIdPrefix(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String monthFormat = String.format("%1$02d", month);
        String dayFormat = String.format("%1$02d", day);
        String hourFormat = String.format("%1$02d", hour);
        return year + monthFormat + dayFormat + hourFormat;
    }

    public String getPimaryKey(){
        String key = RedisKeyConst.PIMARY_KEY;
        String id = null;
        try {
            Long increment = redisTemplate.opsForValue().increment(key, 1);
            id = getIdPrefix() + String.format("%1$022d", increment);
            return id;
        }catch (Exception e){
            log.error("生成id失败", e);
        }
        return id;
    }
}
