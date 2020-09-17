package com.hello.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.hello.ware", "com.hello.commons.config"})
@EnableFeignClients
public class HelloWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWareApplication.class, args);
    }

}
