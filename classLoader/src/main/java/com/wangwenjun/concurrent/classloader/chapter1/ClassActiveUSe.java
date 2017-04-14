package com.wangwenjun.concurrent.classloader.chapter1;

import java.util.Random;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/1 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ClassActiveUse {

    static {
        System.out.println("ClassActiveUse");
    }

    public static void main(String[] args) throws ClassNotFoundException {
/*        new Obj();
        System.out.println(I.a);*/

//        System.out.println(Obj.salary);
//        Obj.printSalary();

//        Class.forName("com.wangwenjun.concurrent.classloader.chapter1.Obj");


//        System.out.println(Child.age);

//        (1)通过子类访问父类的static变量，不会导致子类的初始化.
//        System.out.println(Child.salary);

        //(2）定义引用数组，不会初始化类
//        Obj[] arrays = new Obj[10];


        //(3)final修饰的常量会在编译期间放到常量池中，不会初始化类
//        System.out.println(Obj.salary);
        //(4)final修饰的复杂类型，在编译期间无法计算得出，会初始化类
        System.out.println(Obj.x);
    }


}

class Obj {

    public static final long salary = 100000L;

    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("Obj 被初始化.");
    }


    public static void printSalary() {
        System.out.println("========Obj=printSalary");
    }
}


class Child extends Obj {

    public static int age = 32;

    static {
        System.out.println("Child 被初始化.");
    }
}

interface I {

    int a = 10;
}

//访问某个类或者接口的静态变量，或者对该静态变量进行赋值操作
//1.对某个类的静态变来那个进行读写 ->class
//2.对接口中静态变量进行读取      ->interface
