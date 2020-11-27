package com.justin.esstudy.threads.lesson1;

public class ThreadTest {

    public static void main(String[] args) {
        new HelloThread().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main-tread");
    }
}
