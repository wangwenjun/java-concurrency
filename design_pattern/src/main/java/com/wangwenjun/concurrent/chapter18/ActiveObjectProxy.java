package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
class ActiveObjectProxy implements ActiveObject {

    private final SchedulerThread schedulerThread;

    private final Servant servant;

    public ActiveObjectProxy(SchedulerThread schedulerThread, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult future = new FutureResult();
        schedulerThread.invoke(new MakeStringRequest(servant, future, count, fillChar));
        return future;
    }

    @Override
    public void displayString(String text) {
        schedulerThread.invoke(new DisplayStringRequest(servant, text));
    }
}