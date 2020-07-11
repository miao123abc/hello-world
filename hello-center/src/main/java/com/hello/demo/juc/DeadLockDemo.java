package com.hello.demo.juc;


class DeadLock implements Runnable{
    private String lockA;
    private String lockB;

    DeadLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 持有" + lockA + "\t 尝试获取" + lockB);
            synchronized (lockB){

            }
        }
    }
}


/**
 * 死锁测试
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadLock(lockA, lockB), "A").start();
        new Thread(new DeadLock(lockB, lockA), "B").start();
    }
}
