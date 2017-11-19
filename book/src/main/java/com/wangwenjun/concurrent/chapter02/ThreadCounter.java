package com.wangwenjun.concurrent.chapter02;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCounter extends Thread
{

    final static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args)
    {

        try
        {
            while (true)
            {
                new ThreadCounter().start();
            }
        } catch (Throwable e)
        {
            System.out.println("failed At=>" + counter.get());
            System.exit(1);
        }

//        System.out.println((3 * 1024 * 1024 - 1024 * 1024 - 130 * 1024)/325);
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("The " + counter.getAndIncrement() + " thread be created.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
