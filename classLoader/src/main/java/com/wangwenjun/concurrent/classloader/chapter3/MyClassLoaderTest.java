package com.wangwenjun.concurrent.classloader.chapter3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/2 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        Class<?> aClass = classLoader.loadClass("com.wangwenjun.concurrent.classloader.chapter3.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
        System.out.println(classLoader.getClass().getClassLoader());

        Object obj = aClass.newInstance();
        Method method = aClass.getMethod("hello", new Class<?>[]{});
        Object result = method.invoke(obj, new Object[]{});
        System.out.println(result);



    }
}
