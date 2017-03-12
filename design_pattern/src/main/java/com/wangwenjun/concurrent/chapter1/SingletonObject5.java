package com.wangwenjun.concurrent.chapter1;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/12 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SingletonObject5 {

    private static volatile SingletonObject5 instance;

    private SingletonObject5() {
        //
    }

    //double check add volatile
    public static SingletonObject5 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance)
                    instance = new SingletonObject5();
            }
        }
        return SingletonObject5.instance;
    }
}
