package com.wangwenjun.concurrent.chapter11;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/23 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public final class ActionContext {

    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder {
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext() {
        return ContextHolder.actionContext;
    }

    public Context getContext() {
        return threadLocal.get();
    }

    private ActionContext(){

    }
}