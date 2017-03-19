package com.wangwenjun.concurrent.chapter6;

import java.util.Random;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class WriterWorker extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final SharedData data;

    private final String filler;

    private int index = 0;

    public WriterWorker(SharedData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}
