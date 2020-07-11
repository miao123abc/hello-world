package com.hello.demo.service;

import com.hello.demo.distributed_lock.DistributedLock;
import com.hello.demo.distributed_lock.ZkDistributedLock;
import com.hello.demo.util.GenOrderCodeUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService {

    private GenOrderCodeUtil genOrderCodeUtil = new GenOrderCodeUtil();

    //单机环境加锁不会出现重复订单，分布式还是会重复
    private Lock lock = new ReentrantLock();

    private DistributedLock distributedLock = new ZkDistributedLock();

    /**
     * 生成订单编号
     */
    public void createOrderCode(){
        distributedLock.lock();
        try {
            System.out.println("生成订单号：\t" + genOrderCodeUtil.genOrderCode());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            distributedLock.unLock();
        }

//        lock.lock();
//        try {
//            return genOrderCodeUtil.genOrderCode();
//        }finally {
//            lock.unlock();
//        }
    }
}
