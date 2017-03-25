package com.wangwenjun.concurrent.chapter17;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/25 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Request {

    private final String name;

    private final int number;

    public Request(final String name, final int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executed " + this);
    }

    @Override
    public String toString() {
        return "Request=> No. " + number + " Name. " + name;
    }
}