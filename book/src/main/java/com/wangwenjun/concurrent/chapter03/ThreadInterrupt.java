package com.wangwenjun.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt
{
    public static void main(String[] args)
    {

       /* *//*Thread thread = new Thread(() ->
        {
            try
            {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e)
            {
                System.out.println("Oh, i am be interrupted.");
            }
        });

        thread.start();

        //short block and make sure thread is started.
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();*//*

        Thread.currentThread().interrupt();
        System.out.println("The main thread is interrupted " + Thread.currentThread().isInterrupted());
        TimeUnit.SECONDS.sleep(10);*/

        System.out.println("Main thread is interrupted? " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());
        try
        {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e)
        {
            System.out.println("I will be interrupted still.");
        }
    }
}
