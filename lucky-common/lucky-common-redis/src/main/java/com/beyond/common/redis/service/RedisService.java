package com.beyond.common.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * description: redis工具类
 *
 * @author beyond233
 * @since 2021/2/23 0:14
 */
@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class RedisService {

    @Autowired
    public RedisTemplate redisTemplate;

}
