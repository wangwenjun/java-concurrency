package com.wangwenjun.concurrent.chapter16;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/27
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class TablewarePair
{
    private final Tableware leftTool;

    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool)
    {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool()
    {
        return leftTool;
    }

    public Tableware getRightTool()
    {
        return rightTool;
    }
}
