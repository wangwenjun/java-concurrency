package com.wangwenjun.concurrent.classloader.chapter1;

import java.util.concurrent.atomic.AtomicBoolean;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/2 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ClinitThreadTest {

    public static void main(String[] args) {

//        System.out.println(System.getProperty("sun.boot.class.path"));
//
//        new Thread(() -> new SimpleObject()).start();
//
//        new Thread(() -> new SimpleObject()).start();
    }

    static class SimpleObject {

        private static AtomicBoolean init = new AtomicBoolean(true);

        static {
            System.out.println(Thread.currentThread().getName() + " I will be initial");
            while (init.get()) {

            }
            System.out.println(Thread.currentThread().getName() + " I am finished initial.");
        }
    }
}

