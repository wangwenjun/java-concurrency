package com.wangwenjun.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/***************************************
 * @author:Alex Wang
 * @Date:2017/7/2
 * QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class AtomicCompareTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(123);
//
//        atomicInteger.compareAndSet(124, 2352);
//        System.out.println(atomicInteger.get());
//        Thread.currentThread().join();

        int result = atomicInteger.addAndGet(10);
    }
}