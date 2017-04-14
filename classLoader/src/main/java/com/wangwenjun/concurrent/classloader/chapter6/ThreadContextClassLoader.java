package com.wangwenjun.concurrent.classloader.chapter6;

import com.wangwenjun.concurrent.classloader.chapter3.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***************************************
 * @author:Alex Wang
 * @Date:2017/4/4 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public class ThreadContextClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());


        Class.forName("com.mysql.jdbc.Driver");//(---)
        Connection conn = DriverManager.getConnection("");
    }
}
