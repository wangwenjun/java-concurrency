package com.wangwenjun.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/27
 * 532500648
 ***************************************/
public class InterruptThreadExit
{

    public static void main(String[] args) throws InterruptedException
    {

        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("I will start work");
                for (; ; )
                {
                    //working.
                    try
                    {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e)
                    {
                        break;
                    }
                }
                System.out.println("I will be exiting.");
            }
        };

        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown.");
        t.interrupt();
    }
}
