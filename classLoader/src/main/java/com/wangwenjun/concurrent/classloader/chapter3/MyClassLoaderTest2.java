package com.wangwenjun.concurrent.classloader.chapter3;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/2 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

/**
 * 1.类加载器的委托是优先交给父亲加载器先去尝试加载
 * 2.父加载器和子加载器其实是一种包装关系，或者包含关系
 */
public class MyClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader-1");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader-2");
        classLoader2.setDir("G:\\Teaching\\app\\classloader2");

        Class<?> aClass = classLoader1.loadClass("com.wangwenjun.concurrent.classloader.chapter3.MyObject");
        System.out.println(aClass.hashCode());
        Class<?> aClass2 = classLoader2.loadClass("com.wangwenjun.concurrent.classloader.chapter3.MyObject");
        System.out.println(aClass2.hashCode());
        //sSystem.out.println(((MyClassLoader) aClass.getClassLoader()).getClassLoaderName());
    }
}