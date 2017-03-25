package com.wangwenjun.concurrent.chapter17;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/25 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();

        new TransportThread("Alex", channel).start();
        new TransportThread("Jack", channel).start();
        new TransportThread("William", channel).start();
    }
}