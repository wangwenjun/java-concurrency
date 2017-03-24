package com.wangwenjun.concurrent.chapter16;

import java.io.IOException;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(13345);
        server.start();
        Thread.sleep(15_000L);
        server.shutdown();
    }
}
