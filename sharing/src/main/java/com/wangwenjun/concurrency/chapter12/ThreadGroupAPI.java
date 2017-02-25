package com.wangwenjun.concurrency.chapter12;

import java.util.Arrays;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/25 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ThreadGroupAPI {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
//                while (true) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    break;
                }
//                }
            }
        };

//        tg1.setDaemon(true);
        t1.start();
        Thread.sleep(2_000);
        System.out.println(tg1.isDestroyed());
        tg1.destroy();
        System.out.println(tg1.isDestroyed());
//
//        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
//        Thread t2 = new Thread(tg2, "T2") {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//            }
//        };
//
//        t2.start();
//
//        System.out.println(tg1.activeCount());
//        System.out.println(tg1.activeGroupCount());
//        t2.checkAccess();
////        tg1.destroy();
//
//        System.out.println("=========================");
//        Thread[] ts1 = new Thread[tg1.activeCount()];
//        tg1.enumerate(ts1);
//        Arrays.asList(ts1).forEach(System.out::println);
//
//        System.out.println("=========================");
//        tg1.enumerate(ts1, true);
//        Arrays.asList(ts1).forEach(System.out::println);
//
//        System.out.println("=========================");
//        ts1 = new Thread[10];
//        Thread.currentThread().getThreadGroup().enumerate(ts1, false);
//        Arrays.asList(ts1).forEach(System.out::println);

//        tg1.interrupt();

    }
}
