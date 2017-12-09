package com.wangwenjun.concurrent.chapter21;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

public class ThreadLocalExample
{
    public static void main(String[] args) throws InterruptedException
    {
        //ThreadLocal<Integer> tlocal = new ThreadLocal<>();
/*        IntStream.range(0, 10)
                .forEach(i -> new Thread(() ->
                        {
                            try
                            {

                                tlocal.set(i);
                                System.out.println(currentThread() + " set i " + tlocal.get());
                                TimeUnit.SECONDS.sleep(1);
                                System.out.println(currentThread() + " get i " + tlocal.get());
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }).start()
                );*/

        /*ThreadLocal<Object> threadLocal = new ThreadLocal<Object>()
        {
            @Override
            protected Object initialValue()
            {
                return new Object();
            }
        };

        new Thread(() ->
                System.out.println(threadLocal.get())
        ).start();
        System.out.println(threadLocal.get());*/

        ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
        TimeUnit.SECONDS.sleep(30);

        threadLocal.set(new byte[1024 * 1024 * 100]);
        threadLocal.set(new byte[1024 * 1024 * 100]);
        threadLocal.set(new byte[1024 * 1024 * 100]);
        threadLocal = null;

        currentThread().join();
    }
}