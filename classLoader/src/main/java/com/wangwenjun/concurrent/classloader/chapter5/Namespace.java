package com.wangwenjun.concurrent.classloader.chapter5;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/4 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Namespace {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Namespace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        Class<?> bClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());

    }
}
