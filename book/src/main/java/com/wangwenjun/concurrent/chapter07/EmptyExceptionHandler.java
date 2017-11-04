package com.wangwenjun.concurrent.chapter07;

import java.util.concurrent.TimeUnit;

public class EmptyExceptionHandler
{
    public static void main(String[] args)
    {
        // get current thread's thread group
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(mainGroup.getName());
        System.out.println(mainGroup.getParent());
        System.out.println(mainGroup.getParent().getParent());

        final Thread thread = new Thread(() ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e)
            {
            }

            //here will throw unchecked exception.
            System.out.println(1 / 0);
        }, "Test-Thread");

        thread.start();
    }
}
