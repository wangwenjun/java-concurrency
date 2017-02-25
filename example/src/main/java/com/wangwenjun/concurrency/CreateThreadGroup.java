package com.wangwenjun.concurrency;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/24 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class CreateThreadGroup {

    public static void main(String[] args) {
//
//        ThreadGroup t = new ThreadGroup("test");
//        Path path = Paths.get("G:\\Teaching\\汪文君多线程深入详解实战视频\\汪文君多线程编程实战视频-第一阶段");
//        path.iterator().forEachRemaining(System.out::println);
        File file = new File("G:\\Teaching\\汪文君多线程深入详解实战视频\\汪文君多线程编程实战视频-第一阶段");
        for(File f:file.listFiles()){
            if(f.getName().endsWith(".wmv"))
            System.out.println(f.getName());
        }
    }
}
