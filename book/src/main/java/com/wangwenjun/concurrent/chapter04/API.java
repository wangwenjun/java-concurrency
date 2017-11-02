package com.wangwenjun.concurrent.chapter04;

import static java.lang.Thread.currentThread;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/1
 * 532500648
 ***************************************/
public class API
{

    public synchronized void method1()
    {
        System.out.println(currentThread().getName() + " execute method1");
    }

    public synchronized void method2()
    {
        System.out.println(currentThread().getName() + " execute method2");
    }
}
