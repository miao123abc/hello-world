package com.hello.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.hello.item", "com.hello.commons.config"})
public class HelloItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloItemApplication.class, args);
    }

}
