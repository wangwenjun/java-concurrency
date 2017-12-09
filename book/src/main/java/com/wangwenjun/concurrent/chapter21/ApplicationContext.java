package com.wangwenjun.concurrent.chapter21;

import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationContext
{
    private ApplicationConfiguration configuration;

    private RuntimeInfo runtimeInfo;

    private ConcurrentHashMap<Thread, ActionContext> contexts =
            new ConcurrentHashMap<>();

    public ActionContext getActionContext()
    {
        ActionContext actionContext = contexts.get(Thread.currentThread());
        if (actionContext == null)
        {
            actionContext = new ActionContext();
            contexts.put(Thread.currentThread(), actionContext);
        }
        return actionContext;
    }

    private static class Holder
    {
        private static ApplicationContext instance = new ApplicationContext();
    }

    public static ApplicationContext getContext()
    {
        return Holder.instance;
    }

    public void setConfiguration(ApplicationConfiguration configuration)
    {
        this.configuration = configuration;
    }

    public ApplicationConfiguration getConfiguration()
    {
        return this.configuration;
    }

    public void setRuntimeInfo(RuntimeInfo runtimeInfo)
    {
        this.runtimeInfo = runtimeInfo;
    }

    public RuntimeInfo getRuntimeInfo()
    {
        return this.runtimeInfo;
    }


}