package com.wangwenjun.concurrent.chapter12;

import java.io.IOException;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class WaiterThread extends Thread {

    private final BalkingData balkingData;

    public WaiterThread(BalkingData balkingData) {
        super("Waiter");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                balkingData.save();
                Thread.sleep(1_000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}