package com.hello.demo.distributed_lock;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public abstract class ZkAbstractLock implements DistributedLock{

    private static final String ZKSERVER = "192.168.0.21:2181";

    private static final int SESSION_TIMEOUT = 50000;

    ZkClient zkClient = new ZkClient(ZKSERVER, SESSION_TIMEOUT);

    static final String PATH = "/zk_distribute";

    static CountDownLatch countDownLatch = null;

    @Override
    public void lock() {
        if (tryLock()){
            System.out.println("成功获取锁。。。。");
        }else {
            waitLock();

            lock();
        }
    }

    abstract boolean tryLock();

    abstract void waitLock();

    @Override
    public void unLock() {
        if (null != zkClient){
            zkClient.close();
        }
        System.out.println("释放锁。。。。。。。");
    }
}
