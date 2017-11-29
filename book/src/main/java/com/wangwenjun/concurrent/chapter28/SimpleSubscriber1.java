package com.wangwenjun.concurrent.chapter28;

public class SimpleSubscriber1
{
    @Subscribe
    public void method1(String message)
    {
        System.out.println("==SimpleSubscriber1==method1==" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message)
    {
        System.out.println("==SimpleSubscriber1==method2==" + message);
    }
}
