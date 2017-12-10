package com.wangwenjun.concurrent.chapter21;

import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/9
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ActionContextExample
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            new Thread(() ->
            {
                /*ActionContext.get().setConfiguration(new Configuration());
                System.out.println(ActionContext.get().getConfiguration());*/
            }).start();
        }
    }
}
