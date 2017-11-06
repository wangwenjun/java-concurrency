package com.wangwenjun.concurrent.chapter08;

public interface DenyPolicy
{

    void reject(Runnable runnable, ThreadPool threadPool);


    class DiscardDenyPolicy implements DenyPolicy
    {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool)
        {
            //do nothing
        }
    }

    class AbortDenyPolicy implements DenyPolicy
    {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool)
        {
            throw new RunnableDenyException("The runnable " + runnable + " will be abort.");
        }
    }

    class RunnerDenyPolicy implements DenyPolicy
    {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool)
        {
            if (!threadPool.isShutdown())
            {
                runnable.run();
            }
        }
    }
}
