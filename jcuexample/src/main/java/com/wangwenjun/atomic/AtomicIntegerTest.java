package com.wangwenjun.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/***************************************
 * @author:Alex Wang
 * @Date:2017/7/2
 * QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class AtomicIntegerTest {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int v = atomicInteger.incrementAndGet();
                    System.out.println("Thread:" + currentThread().getName() + "," + v);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int v = atomicInteger.incrementAndGet();
                    System.out.println("Thread:" + currentThread().getName() + "," + v);
                }
            }
        };
        t2.start();

        t1.join();

        t2.join();
    }
}
