package com.wangwenjun.concurrent.chapter05;

import java.util.concurrent.TimeUnit;

public class EventClient
{

    public static void main(String[] args)
    {
        final EventQueue eventQueue = new EventQueue();
        for (int i = 0; i < 3; i++)
            new Thread(() ->
            {
                for (; ; )
                {
                    eventQueue.offer(new EventQueue.Event());
                }
            }, "Producer").start();

        for (int i = 0; i < 3; i++)
            new Thread(() ->
            {
                for (; ; )
                {
                    eventQueue.take();
                    /*try
                    {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }*/
                }
            }, "Consumer").start();

    }
}
