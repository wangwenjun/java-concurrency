package com.wangwenjun.concurrency.chapter3;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/16 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CreateThread3 {

    private int i = 0;

    private byte[] bytes = new byte[1024];

    private static int counter = 0;

    //JVM will create a thread named "main"
    public static void main(String[] args) {
        //create a JVM stack
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    private static void add(int i) {
        ++counter;
        add(i + 1);
    }
}


//StackOverflowError
//21456