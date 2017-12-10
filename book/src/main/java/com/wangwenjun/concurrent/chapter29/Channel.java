package com.wangwenjun.concurrent.chapter29;

public interface Channel<E extends Message>
{
    void dispatch(E message);
}
