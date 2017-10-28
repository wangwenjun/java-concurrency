package com.wangwenjun.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class TimeUnitExample
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread.sleep(12257088L);

        TimeUnit.HOURS.sleep(3);
        TimeUnit.MINUTES.sleep(24);
        TimeUnit.SECONDS.sleep(17);
        TimeUnit.MILLISECONDS.sleep(88);
    }
}