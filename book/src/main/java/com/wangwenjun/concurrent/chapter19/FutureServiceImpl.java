package com.wangwenjun.concurrent.chapter19;

import java.util.concurrent.atomic.AtomicInteger;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/24
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class FutureServiceImpl<IN, OUT> implements FutureService<IN, OUT>
{
    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName()
    {
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable)
    {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() ->
        {
            runnable.run();
            future.finish(null);
        }, getNextName()).start();

        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input, Callback<OUT> callback)
    {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(() ->
        {
            OUT result = task.get(input);
            future.finish(result);
            if (null != callback)
                callback.call(result);
        }, getNextName()).start();

        return future;
    }
}