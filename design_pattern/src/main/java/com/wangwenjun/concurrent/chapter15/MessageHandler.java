package com.wangwenjun.concurrent.chapter15;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class MessageHandler {
    private final static Random random = new Random(System.currentTimeMillis());

    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message) {
        executor.execute(() -> {
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName() + " " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });/*
        new Thread(() -> {
            String value = message.getValue();

            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }

    public void shutdown() {
        ((ExecutorService) executor).shutdown();
    }
}