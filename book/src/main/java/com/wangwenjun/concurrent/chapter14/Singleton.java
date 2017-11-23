package com.wangwenjun.concurrent.chapter14;

public class Singleton
{
    //实例变量
    private byte[] data = new byte[1024];

    private Singleton()
    {
    }

    private enum EnumHolder
    {
        INSTANCE;
        private Singleton instance;

        EnumHolder()
        {
            this.instance = new Singleton();
        }

        public Singleton getInstance()
        {
            return instance;
        }
    }
}