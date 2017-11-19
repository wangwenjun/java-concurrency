package com.wangwenjun.concurrent.chapter09;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/19
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class Simple
{
    static
    {
        System.out.println("I will be initialized");
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        Simple[] simples = new Simple[10];
    }
}
