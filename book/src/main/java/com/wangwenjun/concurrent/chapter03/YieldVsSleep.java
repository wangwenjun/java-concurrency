package com.wangwenjun.concurrent.chapter03;

import java.util.Scanner;
import java.util.stream.IntStream;

public class YieldVsSleep
{
    private final static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException
    {
       /* for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                Scanner scanner = new Scanner(System.in);
                scanner.next();
            }).start();
        }
        Thread.sleep(20);*/
        IntStream.range(0, 2).mapToObj(x -> new Thread(() -> monitor(x), "MyThread-" + x))
                .forEach(Thread::start);
    }

    private static void monitor(int x)
    {
        if (x == 0)
            Thread.yield();
        System.out.println(Thread.currentThread().getName() + " enter.");


        System.out.println(Thread.currentThread().getName() + " do task.");
        System.out.println(Thread.currentThread().getName() + " leave.");
    }
}