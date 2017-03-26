package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
class Servant implements ActiveObject {

    @Override
    public Result makeString(int count, char fillChar) {
        char[] buf = new char[count];
        for (int i = 0; i < count; i++) {
            buf[i] = fillChar;
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {
        try {
            System.out.println("Display:" + text);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}