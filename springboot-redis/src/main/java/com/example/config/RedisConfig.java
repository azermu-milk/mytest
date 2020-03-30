package com.example.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.cache.redis.time-to-live}")
    private Duration timeToLive = Duration.ZERO;

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);

        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofMinutes(1)).disableCachingNullValues();

        Set<String> cacheName = new HashSet<>();
        cacheName.add("my-redis-cache1");
        cacheName.add("my-redis-cache2");

        Map<String, RedisCacheConfiguration> configurationMap  = new HashMap<>();
        configurationMap.put("my-redis-cache1", redisCacheConfiguration);
        configurationMap.put("my-redis-cache2", redisCacheConfiguration.entryTtl(Duration.ofSeconds(120)));

        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                                                            .initialCacheNames(cacheName)
                                                            .withInitialCacheConfigurations(configurationMap)
                                                            .build();
        return cacheManager;
    }
}
