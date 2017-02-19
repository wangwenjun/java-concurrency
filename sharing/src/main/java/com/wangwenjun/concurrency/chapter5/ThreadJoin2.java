package com.wangwenjun.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/17 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ThreadJoin2 {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 is running");
                Thread.sleep(10_000);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t1.join(100,10);


        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));*/

        //start httpServer
        //JettyHttpServer.start();

//        Thread.currentThread().join();

        Thread t1 = new Thread(() -> {

            System.out.println("t1 is running");
            while (true) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                t1.interrupt();
                System.out.println("interrupt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.start();

        try {
            t1.join(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
