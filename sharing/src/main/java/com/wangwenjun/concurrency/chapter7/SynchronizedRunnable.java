package com.wangwenjun.concurrency.chapter7;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SynchronizedRunnable implements Runnable {

    private int index = 1;

    //readonly shared data.
    private final static int MAX = 500;

    //this
    @Override
    public void run() {

        while (true) {
            if (ticket())
                break;
        }
    }

    private boolean ticket() {
        synchronized (this) {
            //1. getField
            if (index > MAX)
                return true;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //index++=>index = index+1
            //1. get Field index
            //2. index = index+1
            //3. put field index
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            return false;
        }
    }
}
