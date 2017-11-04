package com.wangwenjun.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDaemon
{
    public static void main(String[] args)
            throws InterruptedException
    {

        ThreadGroup group1 = new ThreadGroup("Group1");
        new Thread(group1, () ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "group1-thread1").start();

        ThreadGroup group2 = new ThreadGroup("Group2");
        new Thread(group2, () ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "group2-thread1").start();

        //设置daemon为true
        group2.setDaemon(true);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());
    }
}
