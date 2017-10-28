package com.wangwenjun.concurrent.chapter02;

import java.util.concurrent.TimeUnit;

public class ThreadConstruction
{
    public static void main(String[] args) throws InterruptedException
    {
        /*if (args.length < 1)
        {
            System.out.println("Please enter the stack size.");
            System.exit(1);
        }

        ThreadGroup group = new ThreadGroup("TestGroup");
        Runnable runnable = new Runnable()
        {
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run()
            {

                int i = 0;
                recurse(i);
            }

            private void recurse(int i)
            {
                System.out.println(i);
                if (i < MAX)
                {
                    recurse(i + 1);
                }
            }
        };
        Thread thread = new Thread(group, runnable, "Test", Integer.parseInt(args[0]));

        thread.start();*/

        Thread t = new Thread(() ->
        {
            Thread innerThread = new Thread()
            {
                @Override
                public void run()
                {
                    while (true)
                    {
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            };

            innerThread.setDaemon(true);
            innerThread.start();
        });
        t.start();
        TimeUnit.MILLISECONDS.sleep(20);
        System.out.println(t.getState());

        new Thread(() ->
        {
            while (true)
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
