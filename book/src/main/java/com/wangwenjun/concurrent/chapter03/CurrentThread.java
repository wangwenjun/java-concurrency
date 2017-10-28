package com.wangwenjun.concurrent.chapter03;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/25
 * 532500648
 ***************************************/
public class CurrentThread
{
    public static void main(String[] args)
    {
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                //always true
                System.out.println(Thread.currentThread() == this);
            }
        };
        thread.start();

        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }
}
