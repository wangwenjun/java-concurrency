package com.wangwenjun.concurrent.chapter13;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}