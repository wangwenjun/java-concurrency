package com.wangwenjun.concurrent.chapter29;

public class UserOnlineEventChannel extends AsyncChannel
{
    @Override
    protected void handle(Event message)
    {
        UserOnlineEvent event = (UserOnlineEvent) message;
        System.out.println("The User[" + event.getUser().getName() + "] is online.");
    }
}
