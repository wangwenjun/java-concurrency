package com.wangwenjun.concurrent.chapter09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/20
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ClassInit
{
    static
    {
        try
        {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        IntStream.range(0, 5)
                .forEach(i -> new Thread(ClassInit::new));
    }
}
