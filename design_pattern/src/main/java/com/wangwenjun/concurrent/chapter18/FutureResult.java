package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class FutureResult implements Result {

    private Result result;

    private boolean ready = false;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public synchronized Object getResultValue() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}