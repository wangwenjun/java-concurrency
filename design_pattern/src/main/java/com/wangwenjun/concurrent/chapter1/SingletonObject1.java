package com.wangwenjun.concurrent.chapter1;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/12 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SingletonObject1 {

    /**
     * can't lazy load.
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {
        //empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}