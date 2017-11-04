package com.wangwenjun.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupPriority
{
    public static void main(String[] args)
    {
        /*
         * Create a thread group and thread.
         */
        ThreadGroup group = new ThreadGroup("group1");
        Thread thread = new Thread(group, () ->
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
        }, "thread");
        thread.setDaemon(true);
        thread.start();
        System.out.println("group.getMaxPriority()="+group.getMaxPriority());
        System.out.println("thread.getPriority()="+thread.getPriority());
        //
        group.setMaxPriority(3);
        System.out.println("group.getMaxPriority()="+group.getMaxPriority());
        System.out.println("thread.getPriority()="+thread.getPriority());
    }
}
