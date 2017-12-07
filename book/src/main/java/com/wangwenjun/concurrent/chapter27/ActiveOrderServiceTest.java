package com.wangwenjun.concurrent.chapter27;

import static java.lang.Thread.currentThread;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/5
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ActiveOrderServiceTest
{
    public static void main(String[] args)
            throws InterruptedException
    {
//        OrderService orderService = OrderServiceFactory
//                .toActiveObject(new OrderServiceImpl());
//        orderService.order("hello", 453453);
//        System.out.println("Return immediately");
        currentThread().join();
    }
}
