package com.hello.demo.daily;

import com.hello.demo.service.OrderService;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class TestDistributed {

    private static int thread_num = 10;

    private static final CountDownLatch countDownLatch = new CountDownLatch(thread_num);

    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = new OrderService();
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= thread_num; i++) {
            new Thread(() -> {
                new OrderService().createOrderCode();
//                boolean add = set.add(orderCode);
//                System.out.println(orderCode + "\t 添加成功：" + add);
//                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

//        countDownLatch.await();
        System.out.println();
        System.out.println();
        System.out.println("不重复订单总数：" + set.size());
    }
}
