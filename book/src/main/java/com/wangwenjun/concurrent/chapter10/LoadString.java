package com.wangwenjun.concurrent.chapter10;

public class LoadString
{
    public static void main(String[] args)
            throws ClassNotFoundException
    {
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader("G:\\classloader3");
        Class<?> aClass = classLoader.loadClass("java.lang.String");
    }
}