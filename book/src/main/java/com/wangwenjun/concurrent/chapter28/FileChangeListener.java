package com.wangwenjun.concurrent.chapter28;

/***************************************
 * @author:Alex Wang
 * @Date:2017/10/19
 * 532500648
 ***************************************/
public class FileChangeListener
{
    @Subscribe
    public void onChange(FileChangeEvent event)
    {
        System.out.printf("%s-%s\n", event.getPath(), event.getKind());
    }
}
