package com.hello.commons.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION: 默认线程池配置
 **/
@Configuration
public class MyThreadConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(
                Math.min(Runtime.getRuntime().availableProcessors(), 8),
                100,
                5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000),
                new ThreadFactoryBuilder().setNameFormat("hello-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());
    }

}
