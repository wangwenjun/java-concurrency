package com.wangwenjun.concurrent.chapter7;

import java.util.stream.IntStream;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/22 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ImmutableClient {
    public static void main(String[] args) {

        //Share data
        Person person = new Person("Alex", "GuanSu");
        IntStream.range(0, 5).forEach(i ->
                new UsePersonThread(person).start()
        );
    }
}
