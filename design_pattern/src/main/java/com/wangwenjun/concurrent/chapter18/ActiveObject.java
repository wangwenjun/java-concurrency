package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

/**
 * 接受异步消息的主动对象
 */
public interface ActiveObject {

    Result makeString(int count,char fillChar);

    void displayString(String text);
}
