package com.wangwenjun.concurrent.chapter28.monitor;


import com.wangwenjun.concurrent.chapter28.AsyncEventBus;
import com.wangwenjun.concurrent.chapter28.DirectoryTargetMonitor;
import com.wangwenjun.concurrent.chapter28.EventBus;
import com.wangwenjun.concurrent.chapter28.FileChangeListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/19
 * 532500648
 ***************************************/

/**
 * tail
 * Apache Flume 1.7 Spooling
 * <p>
 * .position
 */
public class MonitorClient
{
    public static void main(String[] args) throws Exception
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() * 2);

        final EventBus eventBus = new AsyncEventBus(executor);
        //注册
        eventBus.register(new FileChangeListener());

        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus, "G:\\monitor");
        monitor.startMonitor();
    }
}

