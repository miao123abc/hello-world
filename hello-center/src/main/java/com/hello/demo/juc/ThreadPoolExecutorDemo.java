package com.hello.demo.juc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
//        timerTest();
        executorTest();
    }

    //多个timer 其中一个异常，其他也会终止
    private static void timerTest(){
        Timer timer = new Timer();
        try {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 200){
                        System.out.println(Thread.currentThread().getName() + " __ i = " + i++);
                    }
                }
            }, new Date(1593762900000L));
        } finally {
            timer.cancel();
        }

        Timer timer2 = new Timer();
        try {
            timer2.schedule(new TimerTask() {
                @Override
                public void run() {
                    int j = 0;
                    while (j < 200){
                        System.out.println(Thread.currentThread().getName() + " ___________ j = " + j++);
                        if (j == 100) throw new RuntimeException();
                    }
                }
            }, new Date(1593762900000L));
        } finally {
            timer2.cancel();
        }
    }

    private static void executorTest(){
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
        try {
            executor.schedule(() -> {
                System.out.println(Thread.currentThread().getName());
                int i = 0;
                while (i < 30){
                    System.out.println(Thread.currentThread().getName() + " __ i = " + i++);
                }
            }, 2L, TimeUnit.SECONDS);
        } finally {
            executor.shutdown();
        }

//        ScheduledExecutorService executor2 = new ScheduledThreadPoolExecutor(1);
//        try {
//            executor2.schedule(() -> {
//                int j = 0;
//                while (j < 200){
//                    System.out.println(Thread.currentThread().getName() + " ___________ j = " + j++);
//                    if (j == 100) throw new RuntimeException();
//                }
//            }, 4, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executor2.shutdown();
//        }

    }


}
