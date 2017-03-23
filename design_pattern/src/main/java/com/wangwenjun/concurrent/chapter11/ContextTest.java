package com.wangwenjun.concurrent.chapter11;

import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/23 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1, 5)
                .forEach(i ->
                        new Thread(new ExecutionTask()).start()
                );
    }
}