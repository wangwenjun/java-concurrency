package com.wangwenjun.concurrent.chapter28;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/21
 * 532500648
 ***************************************/
public interface EventExceptionHandler
{
    void handle(Throwable cause, EventContext context);
}
