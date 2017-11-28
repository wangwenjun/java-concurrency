package com.wangwenjun.concurrent.chapter24;

import com.wangwenjun.concurrent.chapter08.BasicThreadPool;
import com.wangwenjun.concurrent.chapter08.ThreadPool;

public class Operator
{
    private final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);

    public void call(String business)
    {
        TaskHandler taskHandler = new TaskHandler(new Request(business));
        threadPool.execute(taskHandler);
    }
}
