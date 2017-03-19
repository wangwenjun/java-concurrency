package com.wangwenjun.concurrent.chapter5;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class User extends Thread {

    private final String myName;

    private final String myAddress;

    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}