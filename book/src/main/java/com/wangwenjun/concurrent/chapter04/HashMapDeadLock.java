package com.wangwenjun.concurrent.chapter04;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HashMapDeadLock
{
    private final HashMap<String, String> map = new HashMap<>();

    public void add(String key, String value)
    {
        this.map.put(key, value);
    }

    public static void main(String[] args)
    {


        final HashMapDeadLock hmdl = new HashMapDeadLock();
        for (int x = 0; x < 2; x++)
            new Thread(() ->
            {
                for (int i = 1; i < Integer.MAX_VALUE; i++)
                {
                    hmdl.add(String.valueOf(i), String.valueOf(i));
                    /*try
                    {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }*/
                }
            }).start();
    }
}
