package com.wangwenjun.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadPriority
{
    public static void main(String[] args)
    {

        Thread t1 = new Thread();
        System.out.println("t1 priority " + t1.getPriority());

        Thread t2 = new Thread(() ->
        {
            Thread t3 = new Thread();
            System.out.println("t3 priority " + t3.getPriority());
        });

        t2.setPriority(6);
        t2.start();
        System.out.println("t2 priority " + t2.getPriority());

        /*ThreadGroup group = new ThreadGroup("test");
        group.setMaxPriority(7);

        Thread thread = new Thread(group, "test-thread");
        thread.setPriority(10);

        System.out.println(thread.getPriority());*/


        /*Thread t1 = new Thread(() ->
        {
            while (true)
            {
                System.out.println("t1");
            }
        });
        t1.setPriority(3);

        Thread t2 = new Thread(() ->
        {
            while (true)
            {
                System.out.println("t2");
            }
        });
        t2.setPriority(10);
        t1.start();
        t2.start();*/

        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        t.start();
        System.out.println(t.getId());
    }
}