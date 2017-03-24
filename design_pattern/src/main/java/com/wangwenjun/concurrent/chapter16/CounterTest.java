package com.wangwenjun.concurrent.chapter16;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10_000L);
        counterIncrement.close();
    }
}