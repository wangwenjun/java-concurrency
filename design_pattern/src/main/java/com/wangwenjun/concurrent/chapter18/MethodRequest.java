package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/26 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

/**
 * 对应ActiveObject的每一个方法
 */
public abstract class MethodRequest {

    protected final Servant servant;

    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}