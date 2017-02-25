package com.wangwenjun.concurrency.chapter12;

import java.util.Arrays;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/25 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ThreadGroupCreate {

    public static void main(String[] args) {
        //use the name

        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                while (true) {
                    try {
//                        System.out.println(getThreadGroup().getName());
//                        System.out.println(getThreadGroup().getParent());
//                        System.out.println(getThreadGroup().getParent().activeCount());
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();


        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                System.out.println(">>>"+tg1.getName());
                Thread[] threads = new Thread[tg1.activeCount()];
                tg1.enumerate(threads);

                Arrays.asList(threads).forEach(System.out::println);
            }
        };

        t2.start();
//
//        System.out.println(tg2.getName());
//        System.out.println(tg2.getParent());

//
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}