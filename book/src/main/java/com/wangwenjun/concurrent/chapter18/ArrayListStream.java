package com.wangwenjun.concurrent.chapter18;

import java.util.Arrays;
import java.util.List;

public class ArrayListStream
{
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("Java", "Thread", "Concurrency", "Scala", "Clojure");
        list.parallelStream().map(String::toUpperCase).forEach(System.out::println);
        list.forEach(System.out::println);
    }
}
