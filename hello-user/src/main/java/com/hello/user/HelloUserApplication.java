package com.hello.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class HelloUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloUserApplication.class, args);
    }

}
