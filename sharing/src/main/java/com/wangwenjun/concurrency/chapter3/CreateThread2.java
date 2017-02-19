package com.wangwenjun.concurrency.chapter3;

import java.util.Arrays;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/16 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
//        System.out.println(t.getThreadGroup());
//        System.out.println(Thread.currentThread().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
//        System.out.println(threadGroup.getName());

        System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);
    }
}
