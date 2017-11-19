package com.wangwenjun.concurrent.chapter05;

public class WaitNotify
{

    private final Object MUTEX = new Object();

    private synchronized void testWait()
    {
        try
        {
            MUTEX.wait();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private synchronized void testNotify()
    {
        MUTEX.notifyAll();
    }

    public static void main(String[] args)
    {
        WaitNotify waitNotify = new WaitNotify();
        waitNotify.testNotify();
    }
}
