package com.hello.demo.distributed_lock;

public interface DistributedLock {

    void lock();

    void unLock();
}
