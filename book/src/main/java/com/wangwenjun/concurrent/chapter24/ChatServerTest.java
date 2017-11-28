package com.wangwenjun.concurrent.chapter24;

import java.io.IOException;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/28
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ChatServerTest
{
    public static void main(String[] args) throws IOException
    {
        new ChatServer().startServer();
    }
}
