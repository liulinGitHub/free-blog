package com.blog.core.utils;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.blog.core.common.consts.Constants;
import com.blog.core.common.enums.ApprovalTypeEnum;
import com.blog.core.common.redis.RedisUtil;
import com.blog.core.common.utils.PrimarykeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassNmae: PrimarykeyUtilTest
 * @description:
 * @Author: liulin
 * @Date: 2020/2/2 14:49
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PrimarykeyUtilTest {

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void getKey(){
//        for (int i = 100; i < 200; i++) {
//            String approvalKey = Constants.getApprovalKey(ApprovalTypeEnum.APPROVAL_ARTICLE, i + "");
//            for (int j = 100; j < 200; j++) {
//                redisUtil.sAdd(approvalKey, j + "");
//            }
//
//        }
//        String approvalKey = (String) redisUtil.get(Constants.getApprovalKey(ApprovalTypeEnum.APPROVAL_ARTICLE, "1001"));

        Set set = new HashSet();
        List list = new ArrayList();
        for(int i = 0;i < 10; i++){
            String key = primarykeyUtil.getPimaryKey();
            set.add(key);
            list.add(key);
            System.out.println(key);
        }
        System.out.println(set.size());
        System.out.println(list.size());



    }
}
