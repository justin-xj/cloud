package com.justin.esstudy.threads.lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class JustinLock implements Lock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    private LinkedBlockingDeque<Thread> waiters = new LinkedBlockingDeque();

    private AtomicInteger count = new AtomicInteger(0);


    @Override
    public void lock() {
        waiters.offer(Thread.currentThread());
        while(!tryLock()){
            LockSupport.park();
        }
        waiters.remove(Thread.currentThread());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        Thread thread = Thread.currentThread();
        if(owner.get() == thread || owner.compareAndSet(null,thread)){
            count.incrementAndGet();
            return true;
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if(owner.get() != Thread.currentThread()){
            throw new IllegalMonitorStateException();
        }
        if(count.decrementAndGet() == 0){
            if(owner.compareAndSet(Thread.currentThread(),null)){
                LockSupport.unpark(waiters.peek());
            }
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
