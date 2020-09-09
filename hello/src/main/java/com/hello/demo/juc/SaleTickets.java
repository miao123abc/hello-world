package com.hello.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class Ticket{
    private int num = 40;
    private Lock lock = new ReentrantLock();

    public void sale(){
        try {
            lock.lock();
            if (num > 0){
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + num-- + "\t 还剩：" + num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

/**
 * 问题：两个售票员卖出 20张票
 *
 * 多线程编程：在高内聚低耦合的前提下，线程 操作 资源类
 */
public class SaleTickets {

    public static void main(String[] args) {
        //创建资源
        Ticket ticket = new Ticket();
        //线程操作资源
        new Thread(() -> {for (int i = 0; i < 50; i++) ticket.sale();}, "A").start();
        new Thread(() -> {for (int i = 0; i < 50; i++) ticket.sale();}, "B").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 30; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "B").start();
    }
}
