package com.wangwenjun.concurrent.chapter9;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/23 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {

        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();
        //serverThread.join();

        Thread.sleep(10000);
        serverThread.close();
    }
}
