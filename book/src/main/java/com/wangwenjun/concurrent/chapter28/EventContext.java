package com.wangwenjun.concurrent.chapter28;

import java.lang.reflect.Method;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/21
 * 532500648
 ***************************************/
public interface EventContext
{

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
