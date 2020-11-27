package com.justin.esstudy.threads.lesson1;

public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("hello world");
    }
}
