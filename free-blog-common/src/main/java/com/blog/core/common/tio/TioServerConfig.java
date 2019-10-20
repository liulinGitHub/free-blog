/**
 *
 */
package com.blog.core.common.tio;

import org.tio.utils.time.Time;

/**
 * @ClassNmae: TioServerConfig
 * @description: TIO 配置文件
 * @Author: liulin
 * @Date: 2019/6/10 00:08
 **/
public abstract class TioServerConfig {
    /**
     * 协议名字(可以随便取，主要用于开发人员辨识)
     */
    public static final String PROTOCOL_NAME = "showcase";

    public static final String CHARSET = "utf-8";

    /**
     * 监听端口
     */
    public static final int SERVER_PORT = 8680;

    /**
     * 心跳超时时间，单位：毫秒
     */
    public static final int HEARTBEAT_TIMEOUT = 1000 * 60;

    /**
     * ip数据监控统计，时间段
     *
     * @author tanyaowu
     */
    public  interface IpStatDuration {
        public static final Long DURATION_1 = Time.MINUTE_1 * 5;
        public static final Long[] IPSTAT_DURATIONS = new Long[]{DURATION_1};
    }

}
