package com.hello.user;

import com.hello.user.component.SMSComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloUserApplicationTests {

    @Autowired
    private SMSComponent smsComponent;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSms(){
//        smsComponent.sendSMSCode("15732687236", "1589");

        smsComponent.sendSMS();
    }

    @Test
    public void testRedis(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("a", "B");

        System.out.println(ops.get("a"));
    }

}
