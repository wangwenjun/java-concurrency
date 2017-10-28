package com.wangwenjun.concurrent.chapter7;

import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/22 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ImmutablePerformance {
    public static void main(String[] args) throws InterruptedException {

        //36470
        //35857 immutable
        long startTimestamp = System.currentTimeMillis();
        SyncObj synObj = new SyncObj();
        synObj.setName("Alex");


        //10000 times
        //22856 sync
        //11856 immutable

        //100000 times
        //230175 sync
        //122096 immutable
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (long l = 0L; l < 100000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" + synObj.toString());
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (long l = 0L; l < 100000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" + synObj.toString());
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();


        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTimestamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "[" + name + "]";
    }
}

class SyncObj {

    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "[" + name + "]";
    }
}