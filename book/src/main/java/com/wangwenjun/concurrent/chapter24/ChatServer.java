package com.wangwenjun.concurrent.chapter24;

import com.wangwenjun.concurrent.chapter08.BasicThreadPool;
import com.wangwenjun.concurrent.chapter08.ThreadPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{
    private final int port;

    private ThreadPool threadPool;

    private ServerSocket serverSocket;

    public ChatServer(int port)
    {
        this.port = port;
    }

    public ChatServer()
    {
        this(13312);
    }

    public void startServer() throws IOException
    {

        this.threadPool = new BasicThreadPool(1, 4, 2, 1000);
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Chat server is started and listen at port: " + port);
        this.listen();
    }

    private void listen() throws IOException
    {
        for (; ; )
        {
            Socket client = serverSocket.accept();
            System.out.println("The client " + client + " connected.");
            this.threadPool.execute(new ClientHandler(client));
        }
    }
}