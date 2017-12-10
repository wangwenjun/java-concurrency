package com.wangwenjun.concurrent.chapter29;

public class InputEvent extends Event
{
    private final int x;
    private final int y;

    public InputEvent(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}