package com.wangwenjun.concurrent.chapter18;

import java.util.List;

public final class Immutable
{
    private final List<String> list;

    public Immutable(List<String> list)
    {
        this.list = list;
    }

    public List<String> getList()
    {
        //Collections.unmodifiableList(this.list)
        return this.list;
    }
}