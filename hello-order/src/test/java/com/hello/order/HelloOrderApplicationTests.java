package com.hello.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloOrderApplicationTests {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRabbitmq(){
        //String name, boolean durable, boolean exclusive, boolean autoDelete, @Nullable Map<String, Object> arguments
        Queue queue = new Queue("test-queue", true, false, false, null);
        amqpAdmin.declareQueue(queue);
        System.out.println("queue = " + queue);
    }

}
