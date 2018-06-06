package com.dhxz.springtest.serializer;

import com.dhxz.springtest.entity.Token;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

public class RedisTokenSerializer extends Jackson2JsonRedisSerializer<Token> {
    public RedisTokenSerializer() {
        super(Token.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD,JsonAutoDetect.Visibility.ANY);
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES,false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        setObjectMapper(mapper);
    }
}
