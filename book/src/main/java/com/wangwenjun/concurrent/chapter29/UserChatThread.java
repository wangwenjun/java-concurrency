package com.wangwenjun.concurrent.chapter29;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.ThreadLocalRandom.current;

public class UserChatThread extends Thread
{
    private final User user;
    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user, AsyncEventDispatcher dispatcher)
    {
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run()
    {
        try
        {
            dispatcher.dispatch(new UserOnlineEvent(user));
            for (int i = 0; i < 5; i++)
            {
                dispatcher.dispatch(new UserChatEvent(user, getName() + "-Hello-" + i));
                TimeUnit.SECONDS.sleep(current().nextInt(10));
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            dispatcher.dispatch(new UserOfflineEvent(user));
        }
    }
}
