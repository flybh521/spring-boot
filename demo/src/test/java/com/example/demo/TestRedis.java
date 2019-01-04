package com.example.demo;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.domain.User;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration
public class TestRedis {

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    
	@Resource
	private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws Exception {
    	redisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
    }
    
//    @Test
//    public void testObj() throws Exception {
//        User user=new User();
//        user.setAccount("adfgasdfasd");
//        
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//        	System.out.println("exists is true");
//        }else{
//        	System.out.println("exists is false");
//        }
//       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//    }
}
