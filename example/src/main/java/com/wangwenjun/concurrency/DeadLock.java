package com.wangwenjun.concurrency;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class DeadLock {
    private final Object LOCK_1 = new Object();
    private final Object LOCK_2 = new Object();
    private int i = 0;

    public void m1() {
        synchronized (LOCK_1) {
            synchronized (LOCK_2) {
                System.out.println("method m1 .." + (i++));
            }
        }
    }

    public void m2() {
        synchronized (LOCK_2) {
            synchronized (LOCK_1) {
                System.out.println("method m2 .." + (i++));
            }
        }
    }

    public static void main(String[] args) {
        final DeadLock deadLock = new DeadLock();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.m2();
                }
            }
        }.start();
    }
}