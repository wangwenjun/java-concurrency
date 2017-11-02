package com.wangwenjun.concurrent.chapter04;

public class IllegalMonitor
{

    private final Object mutex = null;

    public void syncMethod()
    {
        synchronized (mutex)
        {
            //
        }
    }


    private final Object MUTEX_READ = new Object();

    private final Object MUTEX_WRITE = new Object();

    public void read()
    {
        synchronized (MUTEX_READ)
        {
            synchronized (MUTEX_WRITE)
            {
                //...
            }
        }
    }

    public void write()
    {
        synchronized (MUTEX_WRITE)
        {
            synchronized (MUTEX_READ)
            {
                //...
            }
        }
    }


    public static class Task implements Runnable
    {
        private final Object MUTEX = new Object();

        @Override
        public void run()
        {
            //....
            synchronized (MUTEX)
            {
                //.....
            }

            //...
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            new Thread(Task::new).start();
        }
    }

}
