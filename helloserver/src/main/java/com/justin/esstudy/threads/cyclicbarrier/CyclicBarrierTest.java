package com.justin.esstudy.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        int N = 16;

        for (int i = 0; i < N; i++){
            new Thread(() -> {
                try {
                    cyclicBarrier.await(5, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                CyclicBarrierTest.service();
            }).start();
        }
    }
    public static void service(){
        System.out.println("够5个人了");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
