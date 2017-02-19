package com.wangwenjun.concurrency.chapter4;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/17 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class DaemonThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(1_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            //innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();


    }
}
