package com.wangwenjun.concurrent.chapter24;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/28
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class Client
{
    public static void main(String[] args)
    {
        Operator operator = new Operator();
        operator.call("complaints");
        operator.call("transfer business");
    }
}
