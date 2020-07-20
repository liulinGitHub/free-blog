package com.blog.core.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisConfigProperties
 * @Description:
 * @Author: 950103
 * @Date: 2020/7/16 0:00
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigProperties {

    // Redis服务器连接ip地址
    private String host;

    // Redis服务器连接端口
    private Integer port;

    // Redis数据库索引（默认为0）
    private Integer database;

    // Redis服务器连接密码（默认为空）
    private String password;

    // 连接超时时间（毫秒）
    private Integer timeout;

    // 连接池最大连接数（使用负值表示没有限制）
    private Integer maxTotal;

    // 连接池最大阻塞等待时间（使用负值表示没有限制）
    private Integer maxWait;

    // 连接池中的最大空闲连接
    private Integer maxIdle;

    // 连接池中的最小空闲连接
    private Integer minIdle;

    // 关闭超时时间
    private Integer shutdown;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getShutdown() {
        return shutdown;
    }

    public void setShutdown(Integer shutdown) {
        this.shutdown = shutdown;
    }
}
