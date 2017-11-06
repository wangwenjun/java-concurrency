package com.wangwenjun.concurrent.chapter08;

public interface ThreadFactory
{
    Thread createThread(Runnable runnable);
}
