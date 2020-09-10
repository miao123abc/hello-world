package com.hello.user;

import com.hello.user.component.SMSComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloUserApplicationTests {

    @Autowired
    private SMSComponent smsComponent;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSms(){
        smsComponent.sendSMSCode("211", "23");
    }

}
