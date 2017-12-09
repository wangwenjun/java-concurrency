package com.wangwenjun.concurrent.chapter21;

/***************************************
 * @author:Alex Wang
 * @Date:2017/12/7
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class ActionContext
{
    private static final ThreadLocal<Configuration> configuration =
            ThreadLocal.withInitial(Configuration::new);

    private static final ThreadLocal<OtherResource> otherResource =
            ThreadLocal.withInitial(OtherResource::new);

    public static void setConfiguration(Configuration conf)
    {
        configuration.set(conf);
    }

    public static Configuration getConfiguraiton()
    {
        return configuration.get();
    }

    public static void setOtherResource(OtherResource oResource)
    {
        otherResource.set(oResource);
    }

    public static OtherResource getOtherResource()
    {
        return otherResource.get();
    }
}