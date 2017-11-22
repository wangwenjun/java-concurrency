package com.wangwenjun.concurrent.chapter10;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/21
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class RuntimePackage
{
    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException, InstantiationException
    {
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader();
        Class<?> klass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.HelloWorld");

        klass.newInstance();
    }
}
