package com.wangwenjun.concurrent.chapter15;

import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class PerThreadClient {
    public static void main(String[] args) {
        final MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(0, 10)
                .forEach(
                        i -> handler.request(new Message(String.valueOf(i)))
                );

        handler.shutdown();
    }
}