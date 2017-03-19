package com.wangwenjun.concurrent.chapter5;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("ShangLao", "ShangHai", gate);
        User gz = new User("GuangLao", "GuangZhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }
}
