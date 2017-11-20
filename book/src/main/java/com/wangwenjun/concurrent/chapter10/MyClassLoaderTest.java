package com.wangwenjun.concurrent.chapter10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Thread.currentThread;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/20
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class MyClassLoaderTest
{
    public static void main(String[] args)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException, NoSuchMethodException,
            InvocationTargetException, InterruptedException
    {/*
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader
                .loadClass("com.wangwenjun.concurrent.chapter10.HelloWorld");


        System.out.println(aClass.getClassLoader());

        //
        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String) welcomeMethod.invoke(helloWorld);
        System.out.println("Result:" + result);*/

        MyClassLoader classLoader = new MyClassLoader("G:\\classloader1",null);
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.chapter10.HelloWorld");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

 /*       ClassLoader contextClassLoader = currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        currentThread().setContextClassLoader(classLoader);
        System.out.println(currentThread().getContextClassLoader());

        Thread thread = new Thread(() ->
        {
            HelloWorld helloWorld = new HelloWorld();
            System.out.println(helloWorld.getClass().getClassLoader());
        });

        thread.setContextClassLoader(classLoader);
        thread.start();

        Thread.currentThread().join();*/
    }
}