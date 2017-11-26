package com.wangwenjun.concurrent.chapter17;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/25
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
class ReadLock implements Lock
{

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock)
    {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException
    {
        synchronized (readWriteLock.getMutex())
        {
            while (readWriteLock.getWritingWriters() > 0
                    || (readWriteLock.getPreferWriter()
                    && readWriteLock.getWaitingWriters() > 0))
            {
                readWriteLock.getMutex().wait();
            }
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock()
    {
        synchronized (readWriteLock.getMutex())
        {
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
