package com.wangwenjun.concurrency.chapter11;

import java.util.Arrays;
import java.util.Optional;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Test2 {

    public void test() {
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() + ":" + e.getLineNumber())
                        .ifPresent(System.out::println)
                );
    }
}
