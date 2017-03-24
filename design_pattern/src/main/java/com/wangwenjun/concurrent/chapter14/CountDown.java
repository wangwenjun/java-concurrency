package com.wangwenjun.concurrent.chapter14;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CountDown {
    private final int total;

    private int counter = 0;

    public CountDown(int total) {
        this.total = total;
    }

    public void down() {
        synchronized (this) {
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (counter != total) {
                this.wait();
            }
        }
    }
}