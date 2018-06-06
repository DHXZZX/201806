package com.dhxz.springtest.config;

import com.dhxz.springtest.entity.Token;
import com.dhxz.springtest.serializer.RedisTokenSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    RedisSerializer<Token> tokenRedisSerializer() {
        return new RedisTokenSerializer();
    }

    @Bean
    RedisTemplate<String,Token> tokenRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Token> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(tokenRedisSerializer());

        return template;
    }
}
