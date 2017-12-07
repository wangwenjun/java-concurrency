package com.wangwenjun.concurrent.chapter27;

import com.wangwenjun.concurrent.chapter19.Future;
import com.wangwenjun.concurrent.chapter19.FutureService;

import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/3
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class OrderServiceImpl implements OrderService
{
    @ActiveMethod
    @Override
    public Future<String> findOrderDetails(long orderId)
    {
        return FutureService.<Long, String>newService().submit(input ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderID->" + orderId);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return "The order Details Information";
        }, orderId, null);
    }

    @ActiveMethod
    @Override
    public void order(String account, long orderId)
    {
        try
        {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account " + account + ",orderId " + orderId);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}