package com.wangwenjun.concurrent.chapter23;

import java.util.concurrent.TimeUnit;

public class CountDownLatch extends Latch
{
    private final Runnable runnable;

    public CountDownLatch(int limit)
    {
        this(limit, null);
    }

    public CountDownLatch(int limit, Runnable runnable)
    {
        super(limit);
        this.runnable = runnable;
    }

    @Override
    public void await()
            throws InterruptedException
    {
        synchronized (this)
        {
            while (limit > 0)
            {
                this.wait();
            }
        }

        if (null != runnable)
        {
            runnable.run();
        }
    }

    @Override
    public void await(TimeUnit unit, long time)
            throws InterruptedException, WaitTimeoutException
    {
        if (time <= 0)
            throw new IllegalArgumentException("The time is invalid.");

        long remainingNanos = unit.toNanos(time);
        final long endNanos = System.nanoTime() + remainingNanos;
        synchronized (this)
        {
            while (limit > 0)
            {
                if (TimeUnit.NANOSECONDS.toMillis(remainingNanos) <= 0)
                    throw new WaitTimeoutException("The wait time over specify time.");

                this.wait(TimeUnit.NANOSECONDS.toMillis(remainingNanos));
                remainingNanos = endNanos - System.nanoTime();
            }
        }

        if (null != runnable)
        {
            runnable.run();
        }
    }

    @Override
    public void countDown()
    {
        synchronized (this)
        {
            if (limit < 0)
                throw new IllegalStateException("all of task already arrived");
            limit--;
            this.notifyAll();
        }
    }

    @Override
    public int getUnarrived()
    {
        return limit;
    }
}
