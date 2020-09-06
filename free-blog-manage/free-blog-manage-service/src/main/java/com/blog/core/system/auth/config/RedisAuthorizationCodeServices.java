package com.blog.core.system.auth.config;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

import java.util.Objects;

/**
 * @description:
 * @author: 950103
 * @date: 2020/2/13 21:15
 * @version: 1.0
 **/
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    private static final String AUTHORIZATION_CODE = "authorization:code:";

    /**
     * 授权码有效时长
     */
    private long expiration = 300L;

    /**
     * key 前缀
     */
    private String prefix = "";

    private final RedisConnectionFactory connectionFactory;

    //
    private RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();

    private RedisConnection getConnection() {
        return connectionFactory.getConnection();
    }

    public RedisAuthorizationCodeServices(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected void store(String code, OAuth2Authentication oAuth2Authentication) {
        byte[] serializeKey = this.serialize(AUTHORIZATION_CODE + code);
        byte[] serializeAuthentication = this.serialize(oAuth2Authentication);
        RedisConnection redisConnection = this.getConnection();
        try {
            //redis的Pipeline管道，批量操作，节省大量网络往返时间
            redisConnection.openPipeline();
            redisConnection.set(serializeKey, serializeAuthentication);
            redisConnection.expire(serializeKey, expiration);
            redisConnection.closePipeline();
        }finally {
            redisConnection.close();
        }
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        byte[] serializeKey = this.serialize(AUTHORIZATION_CODE + code);
        RedisConnection redisConnection = this.getConnection();
        try {
            byte[] bytes = redisConnection.get(serializeKey);
            if (Objects.nonNull(bytes)) {
                redisConnection.del(bytes);
            }
        }finally {
            redisConnection.close();
        }
        return deserializeAuthentication(serializeKey);
    }

    /**
     * value序列化
     * @param object
     * @return
     */
    private byte[] serialize(Object object) {
        return serializationStrategy.serialize(object);
    }

    /**
     * key序列化
     * @param string
     * @return
     */
    private byte[] serialize(String string) {
        return serializationStrategy.serialize(string);
    }

    /**
     * key序列化
     * @param object
     * @return
     */
    private byte[] serializeKey(Object object) {
        return serialize(prefix + object);
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    private OAuth2Authentication deserializeAuthentication(byte[] bytes) {
        return serializationStrategy.deserialize(bytes, OAuth2Authentication.class);
    }
}
