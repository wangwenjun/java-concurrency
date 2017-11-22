package com.wangwenjun.concurrent.chapter10;

import java.util.ArrayList;
import java.util.List;

public class SimpleClass
{
    private static byte[] buffer = new byte[8];

    private static String str = "";

    private static List<String> list = new ArrayList<>();

    static
    {
        buffer[0] = (byte) 1;
        str = "Simple";
        list.add("element");
        System.out.println(buffer[0]);
        System.out.println(str);
        System.out.println(list.get(0));
    }

    public static void main(String[] args)
    {
        System.out.println(buffer.getClass());
    }
}
