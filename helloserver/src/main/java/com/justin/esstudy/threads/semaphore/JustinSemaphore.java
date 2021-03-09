package com.justin.esstudy.threads.semaphore;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class JustinSemaphore {

    AtomicInteger count = null;

    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue();


    public JustinSemaphore(int c){
        count = new AtomicInteger(c);
    }


    public void acquire(){
        waiters.offer(Thread.currentThread());
        while(!tryAcquire()){
            LockSupport.park();
        }
        waiters.remove(Thread.currentThread());
    }

    public boolean tryAcquire(){
        return count.get() > 0 && count.decrementAndGet() >= 0;
    }

    public void release(){
        if(count.incrementAndGet() > 0){
            LockSupport.unpark(waiters.peek());
        }

    }
}
