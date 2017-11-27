package com.wangwenjun.concurrent.chapter18;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/27
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ShareData
{
    private String shareData = "Hello";

    public void append(String append)
    {
        this.shareData = shareData + append;
        System.out.println(this.shareData);
    }

    public static void main(String[] args)
    {
        final ShareData shareData = new ShareData();

        new Thread(() ->
        {
            int i = 0;
            while (true)
            {
                shareData.append(String.valueOf(i));
                i++;
            }
        }).start();
    }
}
