package com.wangwenjun.concurrent.chapter26;

public class Production extends InstructionBook
{
    //产品编号
    private final int prodID;

    public Production(int prodID)
    {
        this.prodID = prodID;
    }

    @Override
    protected void firstProcess()
    {
        System.out.println("execute the " + prodID + " first process");
    }

    @Override
    protected void secondProcess()
    {
        System.out.println("execute the " + prodID + " second process");
    }

    @Override
    public String toString()
    {
        return "PROD:" + prodID;
    }
}