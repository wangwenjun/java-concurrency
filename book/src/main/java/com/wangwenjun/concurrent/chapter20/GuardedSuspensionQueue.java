package com.wangwenjun.concurrent.chapter20;

import java.util.LinkedList;

public class GuardedSuspensionQueue
{

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void offer(Integer data) throws InterruptedException
    {
        synchronized (this)
        {
            while (queue.size() >= LIMIT)
            {
                this.wait();
            }
            queue.addLast(data);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException
    {
        synchronized (this)
        {
            while (queue.isEmpty())
            {
                this.wait();
            }
            this.notifyAll();
            return queue.removeFirst();
        }
    }
}