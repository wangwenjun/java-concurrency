package com.wangwenjun.concurrent.chapter22;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AutoSaveThread extends Thread
{

    private final Document document;

    public AutoSaveThread(Document document)
    {
        super("DocumentAutoSaveThread");
        this.document = document;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                document.save();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException e)
            {
                break;
            }
        }
    }
}