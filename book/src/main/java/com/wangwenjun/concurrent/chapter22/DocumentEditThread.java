package com.wangwenjun.concurrent.chapter22;

import java.io.IOException;
import java.util.Scanner;

public class DocumentEditThread extends Thread
{

    private final String documentPath;

    private final String documentName;

    private final Scanner scanner = new Scanner(System.in);

    public DocumentEditThread(String documentPath, String documentName)
    {
        super("DocumentEditThread");
        this.documentPath = documentPath;
        this.documentName = documentName;
    }

    @Override
    public void run()
    {
        int times = 0;

        try
        {
            Document document = Document.create(documentPath, documentName);
            while (true)
            {
                String text = scanner.next();
                if ("quit".equals(text))
                {
                    document.close();
                    break;
                }

                document.edit(text);
                if (times == 5)
                {
                    document.save();
                    times = 0;
                }
                times++;

            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
