package com.wangwenjun.concurrent.chapter04;

import static java.lang.Thread.currentThread;

public class ApiDeadLock
{
    private final Object MUTEX = new Object();

    private final API api = new API();

    public void read()
    {
        synchronized (MUTEX)
        {
            api.method1();
            System.out.println(currentThread().getName() + " execute read");
        }
    }

    public void write()
    {
        api.method2();
    }
}
