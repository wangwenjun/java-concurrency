package com.wangwenjun.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupInterrupt
{
    public static void main(String[] args) throws InterruptedException
    {

        ThreadGroup group = new ThreadGroup("TestGroup");

        new Thread(group, () ->
        {
            while (true)
            {
                try
                {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e)
                {
                    //received interrupt SIGNAL and clear quickly
                    break;
                }
            }
            System.out.println("t1 will exit.");
        }, "t1").start();

        new Thread(group, () ->
        {
            while (true)
            {
                try
                {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    //received interrupt SIGNAL and clear quickly
                    break;
                }
            }
            System.out.println("t2 will exit.");
        }, "t2").start();

        //make sure all of above threads started.
        TimeUnit.MILLISECONDS.sleep(2);

        group.interrupt();
    }
}
