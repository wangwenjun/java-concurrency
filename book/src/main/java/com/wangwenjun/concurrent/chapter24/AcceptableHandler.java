package com.wangwenjun.concurrent.chapter24;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class AcceptableHandler implements Runnable
{
    private final SelectionKey selectionKey;

    private final Selector selector;

    public AcceptableHandler(SelectionKey selectionKey,
                             Selector selector)
    {
        this.selectionKey = selectionKey;
        this.selector = selector;
    }

    @Override
    public void run()
    {
        if (!selectionKey.isAcceptable())
            return;
        try
        {
            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel clientChannel = channel.accept();
            System.out.printf("Received the client %s\n", clientChannel.socket().getInetAddress());
            clientChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            clientChannel.register(selector, SelectionKey.OP_READ |
                    SelectionKey.OP_WRITE, buffer);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}