package com.wangwenjun.concurrent.chapter19;

import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/24
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class FutureTest
{
    public static void main(String[] args)
            throws InterruptedException
    {
        FutureService<String, Integer> service = FutureService.newService();
        service.submit(input ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
    }
}
