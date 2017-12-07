package com.wangwenjun.concurrent.chapter27;

class ActiveDaemonThread extends Thread
{
    private final ActiveMessageQueue queue;

    public ActiveDaemonThread(ActiveMessageQueue queue)
    {
        super("ActiveDaemonThread");
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        for (; ; )
        {
            ActiveMessage activeMessage = this.queue.take();
            activeMessage.execute();
        }
    }
}