package com.wangwenjun.concurrent.chapter25;

import java.io.File;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/2
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class StrongReferenceExample
{
    public static void main(String[] args) throws InterruptedException
    {
        /*SoftLRUCache<Integer, Reference> cache = new SoftLRUCache<>(1000, key -> new Reference());
        System.out.println(cache);
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            cache.get(i);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("The " + i + " reference stored at cache.");
        }*/

        ReferenceQueue<Reference> queue = new ReferenceQueue<>();
        PhantomReference<Reference> reference = new PhantomReference<>(new Reference(), queue);
        System.out.println(reference.get());//始终返回null
        System.gc();
        java.lang.ref.Reference<? extends Reference> gcedRef = queue.remove();
        System.out.println(gcedRef);
    }


}

class SocketCleaningTracker
{
    private static final ReferenceQueue<Object> queue = new ReferenceQueue<>();

    static
    {
        new Cleaner().start();
    }

    private static void track(Socket socket)
    {
        new Tracker(socket, queue);
    }

    private static class Cleaner extends Thread
    {
        private Cleaner()
        {
            super("SocketCleaningTracker");
            setDaemon(true);

        }

        @Override
        public void run()
        {
            for (; ; )
            {
                try
                {
                    Tracker tracker = (Tracker) queue.remove();
                    tracker.close();
                } catch (InterruptedException e)
                {
                }
            }
        }
    }

    private static final class Tracker extends PhantomReference<Object>
    {
        private final Socket socket;

        Tracker(Socket socket, ReferenceQueue<? super Object> queue)
        {
            super(socket, queue);
            this.socket = socket;
        }

        public void close()
        {
            try
            {
                socket.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}