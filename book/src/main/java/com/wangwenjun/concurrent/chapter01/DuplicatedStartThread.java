package com.wangwenjun.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/22
 * 532500648
 ***************************************/
public class DuplicatedStartThread
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.start();
    }
}
