package com.justin.esstudy.threads.coundlatch;

import com.justin.esstudy.threads.cyclicbarrier.CyclicBarrierTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        int N = 5;

        for (int i = 0; i < N; i++){
            new Thread(() -> {
                cdl.countDown();

                CyclicBarrierTest.service();
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void service(){
        System.out.println("够5个人了");
        /*try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
