package com.hello.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.hello.order", "com.hello.commons.config"})
public class HelloOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloOrderApplication.class, args);
    }

}
