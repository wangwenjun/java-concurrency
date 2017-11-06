package com.wangwenjun.concurrent.chapter08;

public interface RunnableQueue
{

    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
