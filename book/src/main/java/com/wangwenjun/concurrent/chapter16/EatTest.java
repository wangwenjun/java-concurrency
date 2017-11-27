package com.wangwenjun.concurrent.chapter16;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/27
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class EatTest
{
    public static void main(String[] args)
    {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair tablewarePair = new TablewarePair(fork, knife);
        new EatNoodleThread("A", tablewarePair).start();
        new EatNoodleThread("B", tablewarePair).start();
    }
}
