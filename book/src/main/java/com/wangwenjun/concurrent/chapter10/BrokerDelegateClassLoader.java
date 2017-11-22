package com.wangwenjun.concurrent.chapter10;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/***************************************
 * @author:Alex Wang
 * @Date:2017/11/20
 * QQ: 532500648
 * QQ群:463962286
 ***************************************/
public class BrokerDelegateClassLoader extends ClassLoader
{

    private final static Path DEFAULT_CLASS_DIR = Paths.get("G:", "classloader1");

    private final Path classDir;

    public BrokerDelegateClassLoader()
    {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public BrokerDelegateClassLoader(String classDir)
    {
        super();
        this.classDir = Paths.get(classDir);
    }

    public BrokerDelegateClassLoader(String classDir, ClassLoader parent)
    {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    @Override
    protected Class<?> findClass(String name)
            throws ClassNotFoundException
    {
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0)
        {
            throw new ClassNotFoundException("Can not load the class " + name);
        }

        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name))
        {
            Class<?> klass = findLoadedClass(name);
            if (klass == null)
            {
                if (name.startsWith("java.") || name.startsWith("javax"))
                {
                    try
                    {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e)
                    {
                        //ignore
                    }
                } else
                {
                    try
                    {
                        klass = this.findClass(name);
                    } catch (ClassNotFoundException e)
                    {
                        //ignore
                    }

                    if (klass == null)
                    {
                        if (getParent() != null)
                        {
                            klass = getParent().loadClass(name);
                        } else
                        {
                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }
                }
            }

            if (null == klass)
            {
                throw new ClassNotFoundException("The class " + name + " not found.");
            }

            if (resolve)
            {
                resolveClass(klass);
            }
            return klass;
        }
    }

    private byte[] readClassBytes(String name)
            throws ClassNotFoundException
    {
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        if (!classFullPath.toFile().exists())
            throw new ClassNotFoundException("The class " + name + " not found.");
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e)
        {
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }
    }

    @Override
    public String toString()
    {
        return "Broker Delegate ClassLoader";
    }
}