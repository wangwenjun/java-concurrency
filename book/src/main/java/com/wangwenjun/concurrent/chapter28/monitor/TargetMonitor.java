package com.wangwenjun.concurrent.chapter28.monitor;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/19
 * 532500648
 ***************************************/
public interface TargetMonitor
{

    void startMonitor() throws Exception;

    void stopMonitor() throws Exception;
}
