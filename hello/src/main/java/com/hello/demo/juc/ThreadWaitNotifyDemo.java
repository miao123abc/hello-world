package com.hello.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 空调资源类，生产一个 卖一个
 *
 * 线程通知：
 * 1.synchronized 对应wait notify notifyAll
 * 2.lock         对应await signal signalAll （可以实现顺序访问，精准通知）
 */
class AirCondition{
    private int num = 0; //0:A -> 1:B -> 2:C
    private Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    //相当于lock的钥匙
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void print1(){
        try {
            lock.lock();
            while (num != 0)
            {
                condition1.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知
            num = 1;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print2(){
        try {
            lock.lock();
            while (num != 1)
            {
                condition2.await();
            }
            //干活
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + num);
            }
            //通知
            num = 2;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print3(){
        try {
            lock.lock();
            while (num != 2)
            {
                condition3.await();
            }
            //干活
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + num);
            }
            //通知
            num = 0;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void incr(){
        try {
            lock.lock();
            //判断 使用while，if会出现虚假唤醒的问题
            while (num != 0)
            {
                condition.await(); //this.wait();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知
            condition.signalAll(); //this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decr() {
        try {
            lock.lock();
            //判断 使用while，if会出现虚假唤醒的问题
            while (num == 0)
            {
                condition.await(); //this.wait();
            }
            //干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知
            condition.signalAll(); //this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    //synchronized方法
    /*public synchronized void decr() throws InterruptedException {
        while (num == 0)
        {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }*/


}
/**
 * 问题1：实现4个线程 操作初始值为0的一个变量，一个线程加1，一个线程减1，交替执行10次
 * 问题2：实现3个线程 顺序打印5次 A 1次 —> B 2次 -> C 3次
 *
 * 1.低内聚高耦合下，线程操作资源类
 * 2.操作 -- 判断->干活->通知
 * 3.多线程交互中，必须防止虚假唤醒，即判断使用while，不用if
 * 4.给定标志位
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        //问题2 测试
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                airCondition.print1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                airCondition.print2();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                airCondition.print3();
            }
        }, "C").start();

        //以下问题1测试
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                airCondition.incr();
//            }
//        }, "A").start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                airCondition.decr();
//            }
//        }, "B").start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                airCondition.incr();
//            }
//        }, "C").start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                airCondition.decr();
//            }
//        }, "D").start();

    }
}
