package com.wangwenjun.concurrent.chapter5;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

/**
 * SharedResource
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    /**
     * 临界值
     *
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        /*race*/
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*******BROKEN********" + toString());
        }
    }

    public synchronized String toString() {
        return "No." + counter + ":" + name + "," + address;
    }
}