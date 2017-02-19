package com.wangwenjun.concurrency.chapter3;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/16 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);
        t1.start();
    }
}
