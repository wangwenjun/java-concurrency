package com.wangwenjun.concurrent.chapter05;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

public class BooleanLock implements Lock
{

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException
    {
        synchronized (this)
        {
            while (locked)
            {
                if (!blockedList.contains(currentThread()))
                    blockedList.add(currentThread());
                this.wait();
            }

            blockedList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException
    {
        synchronized (this)
        {
            if (mills <= 0)
            {
                this.lock();
            } else
            {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked)
                {
                    if (remainingMills <= 0)
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    if (!blockedList.contains(currentThread()))
                        blockedList.add(currentThread());
                    this.wait(remainingMills);
                    remainingMills = endMills - currentTimeMillis();
                }

                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock()
    {
        synchronized (this)
        {
            if (currentThread == currentThread())
            {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock monitor.")
                        .ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads()
    {
        return Collections.unmodifiableList(blockedList);
    }
}