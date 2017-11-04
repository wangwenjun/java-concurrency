package com.wangwenjun.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupBasic
{
    public static void main(String[] args) throws InterruptedException
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

        //make sure the thread is started
        TimeUnit.MILLISECONDS.sleep(1);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("activeCount=" + mainGroup.activeCount());
        System.out.println("activeGroupCount=" + mainGroup.activeGroupCount());
        System.out.println("getMaxPriority=" + mainGroup.getMaxPriority());
        System.out.println("getName=" + mainGroup.getName());
        System.out.println("getParent=" + mainGroup.getParent());
        mainGroup.list();
        System.out.println("--------------------------");
        System.out.println("parentOf="+mainGroup.parentOf(group));
        System.out.println("parentOf="+mainGroup.parentOf(mainGroup));
    }
}
