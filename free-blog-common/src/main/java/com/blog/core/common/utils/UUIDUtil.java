package com.blog.core.common.utils;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.UUID;

/**
 * @ClassName: UUIDUtil
 * @description:
 * @author: 950103
 * @create: 2020-04-29 16:53
 * @Version: 1.0
 */
public class UUIDUtil {

    @Autowired
    private PrimarykeyUtil primarykeyUtil;

    private static final String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    /**
     * 生成8位uuid
     *
     * @return
     * @author wangfan
     */
    public static String randomUUID8() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    /**
     * 生成32位uuid
     *
     * @return
     * @author wangfan
     */
    public static String randomUUID32() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

}
