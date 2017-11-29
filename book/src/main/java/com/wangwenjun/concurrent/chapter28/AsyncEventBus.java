package com.wangwenjun.concurrent.chapter28;

import java.util.concurrent.ThreadPoolExecutor;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/21
 * 532500648
 ***************************************/
public class AsyncEventBus extends EventBus
{

    AsyncEventBus(String busName, EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor)
    {
        super(busName, exceptionHandler, executor);
    }


    public AsyncEventBus(String busName, ThreadPoolExecutor executor)
    {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor)
    {
        this("default-async", null, executor);
    }

    public AsyncEventBus(EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor)
    {
        this("default-async", exceptionHandler, executor);
    }
}
