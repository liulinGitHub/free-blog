package com.blog.core.common.redis;

import com.blog.core.common.utils.FastJson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @program: RedisConfig
 * @description: redis配置类
 * @author: liulin
 * @create: 2019-05-15 18:39
 * @Version: 1.0
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConfigProperties redisConfigProperties;

    /**
     * @Description 自定义缓存key的生成策略。默认的生成策略是看不懂的(乱码内容)
     * 通过Spring 的依赖注入特性进行自定义的配置注入并且此类是一个配置类可以更多程度的自定义配置
     * @Param
     * @return org.springframework.cache.interceptor.KeyGenerator
     **/
    @Bean
    @Override
    @Nullable
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object param : params) {
                    sb.append(param);
                }
                return sb.toString();
            }
        };
    }

    /**
     *
     * @Description 缓存配置管理器
     * @Param
     * @return CacheManager
     **/
    @Bean
    @Override
    public CacheManager cacheManager() {
        //以锁写入的方式创建RedisCacheWriter对象
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(getConnectionFactory());
        //创建默认缓存配置对象
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, config);
        return cacheManager;
    }

    /**
     *
     * @Description 获取缓存连接
     * @Param []
     * @return org.springframework.data.redis.connection.RedisConnectionFactory
     **/
    @Bean
    public RedisConnectionFactory getConnectionFactory() {
        //单机模式
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(redisConfigProperties.getHost());
        configuration.setPort(redisConfigProperties.getPort());
        configuration.setDatabase(redisConfigProperties.getDatabase());
        configuration.setPassword(RedisPassword.of(redisConfigProperties.getPassword()));
        //哨兵模式
        //RedisSentinelConfiguration configuration1 = new RedisSentinelConfiguration();
        //集群模式
        //RedisClusterConfiguration configuration2 = new RedisClusterConfiguration();
        LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration, getPoolConfig());
        // 是否允许多个线程操作共用同一个缓存连接，默认true，false时每个操作都将开辟新的连接
        //factory.setShareNativeConnection(false);
        return factory;
    }

    /**
     *
     * @Description 获取缓存连接池
     * @Param []
     * @return LettucePoolingClientConfiguration
     **/
    @Bean
    public LettucePoolingClientConfiguration getPoolConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(redisConfigProperties.getMaxTotal());
        config.setMaxWaitMillis(redisConfigProperties.getMaxWait());
        config.setMaxIdle(redisConfigProperties.getMaxIdle());
        config.setMinIdle(redisConfigProperties.getMinIdle());
        LettucePoolingClientConfiguration pool = LettucePoolingClientConfiguration.builder()
                .poolConfig(config)
                .commandTimeout(Duration.ofMillis(redisConfigProperties.getTimeout()))
                .shutdownTimeout(Duration.ofMillis(redisConfigProperties.getShutdown()))
                .build();
        return pool;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(getConnectionFactory());
        // 开启事务
        template.setEnableTransactionSupport(true);
        return template;
    }

    /**
     * 获取缓存操作助手对象
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        //创建Redis缓存操作助手RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(getConnectionFactory());
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        RedisTemplate对象需要指明Key序列化方式，如果声明StringRedisTemplate对象则不需要
//        template.setKeySerializer(stringRedisSerializer);
//        hash的key也采用String的序列化方式
//        template.setHashKeySerializer(stringRedisSerializer);
//        以下代码为将RedisTemplate的Value序列化方式由JdkSerializationRedisSerializer
//         更换为Jackson2JsonRedisSerializer/FastJson2JsonRedisSerializer两种方式
//        这两种序列化方式结果清晰、容易阅读、存储字节少、速度快，所以推荐更换
//        二者选其一
        //1.jackson序列化方式
        template.setKeySerializer(jackson2JsonRedisSerializer());
        template.setHashKeySerializer(jackson2JsonRedisSerializer());
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer());
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer());
        // 开启事务
        template.setEnableTransactionSupport(true);
        //2.FastJson序列化方式
//        FastJson2JsonRedisSerializer fastJson2JsonRedisSerializer =new FastJson2JsonRedisSerializer<Object>(Object.class);
//        template.setStringSerializer(fastJson2JsonRedisSerializer);
//        template.setKeySerializer(fastJson2JsonRedisSerializer);
//        // value序列化方式采用fastson
//        template.setValueSerializer(fastJson2JsonRedisSerializer);
//        // hash的value序列化方式采用jackson
//        template.setHashValueSerializer(fastJson2JsonRedisSerializer);
        //template.setEnableTransactionSupport(true);//是否启用事务
        return template;
    }

    @Bean
    public Jackson2JsonRedisSerializer jackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer
                = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper());
        return jackson2JsonRedisSerializer;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return om;
    }
}
