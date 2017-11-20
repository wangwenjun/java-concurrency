package com.wangwenjun.concurrent.chapter09;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/19
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class Child extends Parent
{
    static
    {
        System.out.println("The child will be initialized");
    }

    public static int x = 10;

    public int test(){
     return 0;
    }

    public void test(int x){

    }
}
