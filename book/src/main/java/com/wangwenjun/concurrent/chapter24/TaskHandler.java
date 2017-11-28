package com.wangwenjun.concurrent.chapter24;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

public class TaskHandler implements Runnable
{

    private final Request request;

    public TaskHandler(Request request)
    {
        this.request = request;
    }

    @Override
    public void run()
    {
        System.out.println("Begin handle " + request);
        slowly();
        System.out.println("End handle " + request);
    }

    private void slowly()
    {
        try
        {
            TimeUnit.SECONDS.sleep(current().nextInt(10));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
