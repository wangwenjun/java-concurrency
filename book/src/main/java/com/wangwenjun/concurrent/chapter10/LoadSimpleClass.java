package com.wangwenjun.concurrent.chapter10;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/22
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class LoadSimpleClass
{
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException
    {
        BrokerDelegateClassLoader classLoader = new BrokerDelegateClassLoader("G\\classloader2");
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.SimpleClass");
        System.out.println(classLoader.getParent());
        aClass.newInstance();
    }
}
