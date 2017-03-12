package com.wangwenjun.concurrent.chapter1;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/12 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SingletonObject4 {

    private static SingletonObject4 instance;

    private Object obj;//
    private SingletonObject4() {
        //empty
        int i = 0;
        int j = 10;

        //i = 0,j=10;
        //obj;

    }

    //double check
    public static SingletonObject4 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance)
                    instance = new SingletonObject4();
            }
        }

        return SingletonObject4.instance;
    }
}
