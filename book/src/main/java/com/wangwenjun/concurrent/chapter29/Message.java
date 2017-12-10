package com.wangwenjun.concurrent.chapter29;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/10
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public interface Message
{
    Class<? extends Message> getType();
}
