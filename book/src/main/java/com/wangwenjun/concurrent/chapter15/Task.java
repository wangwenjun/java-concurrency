package com.wangwenjun.concurrent.chapter15;

@FunctionalInterface
public interface Task<T>
{
    T call();
}
