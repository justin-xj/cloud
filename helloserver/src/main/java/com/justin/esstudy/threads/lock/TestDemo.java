package com.justin.esstudy.threads.lock;

public class TestDemo {

    private JustinLock lock = new JustinLock();

    private int i = 0;

    public void add() { // 参考我的源码注释。
        //i++;

        lock.lock();
        try {
            i++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestDemo ld = new TestDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    ld.add();
                }
            }).start();
        }
        Thread.sleep(2000L);
        System.out.println(ld.i);
    }
}
