package com.wangwenjun.concurrent.chapter4;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/18 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public interface LifeCycleListener {
    
    void onEvent(ObservableRunnable.RunnableEvent event);
}
