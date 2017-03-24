package com.wangwenjun.concurrent.chapter15;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Message {
    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}