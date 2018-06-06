package com.dhxz.springtest;

import com.dhxz.springtest.entity.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestApplicationTests {

	@Autowired
	private RedisTemplate<String,Token> tokenRedisTemplate;

	@Test
	public void contextLoads() {
		ValueOperations<String, Token> ops =
				tokenRedisTemplate.opsForValue();

		ops.set("test",Token.builder().accessKey("111").clientId("512146645").build());
		Token token = ops.get("test");

		Token build = Token.builder().build();
		BeanUtils.copyProperties(token,build);
		System.out.println(token);
		System.out.println(build);
	}

}
