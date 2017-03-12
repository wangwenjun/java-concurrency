package com.wangwenjun.concurrency;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/11 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class VolatileTest {

    private static  int MY_INT = 0;

    public static void main(String[] args) {
        new Reader().start();
        new Updater().start();
    }

    static class Reader extends Thread {

        @Override
        public void run() {
            int local_value = MY_INT;
            while (local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.println("The value updated to [" + MY_INT + "]");
                    local_value = MY_INT;
                }
            }
        }
    }

    static class Updater extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("Update the value to [" + (local_value + 1) + "]");
                MY_INT = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
