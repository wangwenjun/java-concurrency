package com.wangwenjun.concurrency.chapter3;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/16 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("==========");
            }
        };
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() -> {
            System.out.println("Runnable...");
        });

        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(() -> {
            System.out.println("Runnable..." + Thread.currentThread().getName());
        }, "RunnableThread");

        t5.start();
    }
}
