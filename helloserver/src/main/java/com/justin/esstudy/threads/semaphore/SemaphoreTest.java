package com.justin.esstudy.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        int N = 8;

        for(int i = 0; i < N; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SemaphoreTest.service();

                    semaphore.release();
                }
            }).start();
        }
    }

    public static void service(){
        System.out.println("xxxxx");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
