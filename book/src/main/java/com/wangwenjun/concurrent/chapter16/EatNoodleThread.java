package com.wangwenjun.concurrent.chapter16;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/27
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class EatNoodleThread extends Thread
{
    private final String name;

    private final TablewarePair tablewarePair;

    public EatNoodleThread(String name, TablewarePair tablewarePair)
    {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run()
    {
        while (true)
        {
            this.eat();
        }
    }

    private void eat()
    {
        synchronized (tablewarePair)
        {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " is eating now.");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }
}