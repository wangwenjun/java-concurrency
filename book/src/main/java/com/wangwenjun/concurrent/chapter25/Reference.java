package com.wangwenjun.concurrent.chapter25;

public class Reference
{
    //1M
    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("the reference will be GC.");
    }
}