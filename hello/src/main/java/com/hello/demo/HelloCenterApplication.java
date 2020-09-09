package com.hello.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HelloCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloCenterApplication.class, args);
    }

}
