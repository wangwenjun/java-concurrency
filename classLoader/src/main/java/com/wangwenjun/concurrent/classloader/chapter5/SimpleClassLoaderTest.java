package com.wangwenjun.concurrent.classloader.chapter5;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/4 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SimpleClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("java.lang.String");
//        System.out.println(aClass.getClassLoader());
    }
}
