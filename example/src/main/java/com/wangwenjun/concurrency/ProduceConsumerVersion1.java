package com.wangwenjun.concurrency;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/19 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ProduceConsumerVersion1 {
    private final Object LOCK = new Object();

    private int i = 0;

    public void produce() {
        synchronized (LOCK) {
            System.out.println("P->" + (i++));
        }
    }

    public void consume() {
        synchronized (LOCK) {
            System.out.println("C->" + i);
        }
    }

    public static void main(String[] args) {
        final ProduceConsumerVersion1 produceConsumer = new ProduceConsumerVersion1();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    produceConsumer.produce();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true)
                    produceConsumer.consume();
            }
        }.start();
    }
}
