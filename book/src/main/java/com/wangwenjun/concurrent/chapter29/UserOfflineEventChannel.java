package com.wangwenjun.concurrent.chapter29;

public class UserOfflineEventChannel extends AsyncChannel
{
    @Override
    protected void handle(Event message)
    {
        UserOfflineEvent event = (UserOfflineEvent) message;
        System.out.println("The User[" + event.getUser().getName() + "] is offline.");
    }
}
