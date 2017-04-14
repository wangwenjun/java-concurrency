package com.wangwenjun.concurrent.classloader.chapter1;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/2 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class LoaderClass {
    public static void main(String[] args) {
/*        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();


        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
        System.out.println(myObject1.getClass() == myObject4.getClass());

        System.out.println(MyObject.x);*/

        System.out.println(Sub.x);
    }
}

class MyObject {

    public static int x = 10;

    static {
        System.out.println(x);
        x = 10 + 1;
//
//        y = 200;
//        System.out.println(y);
    }

//    private static int y = 20;

}

class Parent {

    static {
        System.out.println("parent");
    }
}

class Sub extends Parent {

    public static int x = 100;

    static {
        System.out.println("child");
    }

}