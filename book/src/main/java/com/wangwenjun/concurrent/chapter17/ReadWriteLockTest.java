package com.wangwenjun.concurrent.chapter17;

import static java.lang.Thread.currentThread;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/25
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ReadWriteLockTest
{
    //This is the example for read write lock
    private final static String text = "Thisistheexampleforreadwritelock";

    public static void main(String[] args)
    {
        final ShareData shareData = new ShareData(50);
        for (int i = 0; i < 2; i++)
        {
            new Thread(() ->
            {
                for (int index = 0; index < text.length(); index++)
                {
                    try
                    {
                        char c = text.charAt(index);
                        shareData.write(c);
                        System.out.println(currentThread() + " write " + c);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                while (true)
                    try
                    {
                        System.out.println(currentThread() + " read " + new String(shareData.read()));
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }).start();
        }
    }
}
