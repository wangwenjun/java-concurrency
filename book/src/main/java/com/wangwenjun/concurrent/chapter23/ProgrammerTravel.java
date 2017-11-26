package com.wangwenjun.concurrent.chapter23;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ProgrammerTravel extends Thread
{

    private final Latch latch;
    private final String programmer;
    private final String transportation;

    public ProgrammerTravel(Latch latch, String programmer, String transportation)
    {
        this.latch = latch;
        this.programmer = programmer;
        this.transportation = transportation;
    }

    @Override
    public void run()
    {
        System.out.println(programmer + " start take the transportation [" + transportation + "]");
        try
        {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(programmer + " arrived by " + transportation);
        latch.countDown();
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        Latch latch = new CountDownLatch(4, () -> System.out.println("we are arrived"));
        new ProgrammerTravel(latch, "Alex", "Bus").start();
        new ProgrammerTravel(latch, "Gavin", "Walking").start();
        new ProgrammerTravel(latch, "Jack", "Subway").start();
        new ProgrammerTravel(latch, "Dillon", "Bicycle").start();
        latch.await();
    }
}
