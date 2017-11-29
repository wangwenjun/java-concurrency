package com.wangwenjun.concurrent.chapter26;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Worker extends Thread
{
    private final ProductionChannel channel;

    private final static Random random =
            new Random(System.currentTimeMillis());

    public Worker(String workerName, ProductionChannel channel)
    {
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Production production = channel.takeProduction();
                System.out.println(getName() + " process the " + production);
                production.create();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}