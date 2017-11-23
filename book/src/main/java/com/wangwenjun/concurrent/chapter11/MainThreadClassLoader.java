package com.wangwenjun.concurrent.chapter11;

import static java.lang.Thread.currentThread;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/22
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class MainThreadClassLoader
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        System.out.println(currentThread().getContextClassLoader());
        Class.forName("com.mysql.jdbc.Driver");
    }
}
