package com.wangwenjun.concurrent.chapter09;

import java.util.Random;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/19
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class GlobalConstants
{
    static
    {
        System.out.println("The GlobalConstants will be initialized.");
    }

    public final static int MAX = 100;
    public final static int RANDOM = new Random().nextInt();
}
