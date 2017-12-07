package com.wangwenjun.concurrent.chapter27;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/5
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ActiveMethod
{
}
