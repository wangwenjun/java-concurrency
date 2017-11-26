package com.wangwenjun.concurrent.chapter17;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/25
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
class WriteLock implements Lock
{

    private final ReadWriteLockImpl readWriteLock;

    WriteLock(ReadWriteLockImpl readWriteLock)
    {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException
    {
        synchronized (readWriteLock.getMutex())
        {
            try
            {
                readWriteLock.incrementWaitingWriters();
                while (readWriteLock.getReadingReaders() > 0
                        || readWriteLock.getWritingWriters() > 0)
                {
                    readWriteLock.getMutex().wait();
                }
            } finally
            {
                this.readWriteLock.decrementWaitingWriters();
            }
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock()
    {
        synchronized (readWriteLock.getMutex())
        {
            readWriteLock.decrementWritingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
