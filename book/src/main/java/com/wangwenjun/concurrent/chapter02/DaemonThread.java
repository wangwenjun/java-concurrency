package com.wangwenjun.concurrent.chapter02;

public class DaemonThread
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(() ->
        {
            while (true)
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");
    }
}
