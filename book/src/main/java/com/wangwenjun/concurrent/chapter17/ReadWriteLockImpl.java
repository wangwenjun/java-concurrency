package com.wangwenjun.concurrent.chapter17;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/25
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
class ReadWriteLockImpl implements ReadWriteLock
{
    private final Object MUTEX = new Object();

    private int writingWriters = 0;

    private int waitingWriters = 0;

    private int readingReaders = 0;

    private boolean preferWriter;

    public ReadWriteLockImpl()
    {
        this(true);
    }

    public ReadWriteLockImpl(boolean preferWriter)
    {
        this.preferWriter = preferWriter;
    }


    public Lock readLock()
    {
        return new ReadLock(this);
    }

    public Lock writeLock()
    {
        return new WriteLock(this);
    }

    void incrementWritingWriters()
    {
        this.writingWriters++;
    }

    void incrementWaitingWriters()
    {
        this.waitingWriters++;
    }

    void incrementReadingReaders()
    {
        this.readingReaders++;
    }

    void decrementWritingWriters()
    {
        this.writingWriters--;
    }

    void decrementWaitingWriters()
    {
        this.waitingWriters--;
    }

    void decrementReadingReaders()
    {
        this.readingReaders--;
    }

    public int getWritingWriters()
    {
        return this.writingWriters;
    }

    public int getWaitingWriters()
    {
        return this.waitingWriters;
    }

    public int getReadingReaders()
    {
        return this.readingReaders;
    }

    Object getMutex()
    {
        return this.MUTEX;
    }

    boolean getPreferWriter()
    {
        return this.preferWriter;
    }

    void changePrefer(boolean preferWriter)
    {
        this.preferWriter = preferWriter;
    }
}