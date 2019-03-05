package com.zhangchao.classLoader.hotswap;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.HashMap;

public class HotSwapURLClassLoader extends URLClassLoader {
    //缓存加载class文件的最后最新修改时间
    public static Map<String, Long> cacheLastModifyTimeMap = new HashMap<String, Long>();

    //工程class类所在的路径
    public static String projectClassPath = "F:\\idea-project\\IO\\out\\production\\IO\\";

    //所有的测试的类都在同一个包下
    public static String packagePath = "com\\zhangchao\\classLoader\\";

    private static HotSwapURLClassLoader hcl = new HotSwapURLClassLoader();

    public HotSwapURLClassLoader() {
        //设置ClassLoader加载的路径
        super(getMyURLs());
    }

    public static HotSwapURLClassLoader getClassLoader() {
        return hcl;
    }

    private static URL[] getMyURLs() {
        URL url = null;
        try {
            url = new File(projectClassPath).toURI().toURL();
            //file:/F:/viemall_workspace/viemall/WebRoot/WEB-INF/classes/
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new URL[]{url};
    }


    /**
     * 重写loadClass，不采用双亲委托机制("java."开头的类还是会由系统默认ClassLoader加载)
     */
    @Override
    public Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class clazz = null;
        //查看HotSwapURLClassLoader实例缓存下，是否已经加载过class
        //不同的HotSwapURLClassLoader实例是不共享缓存的
        clazz = findLoadedClass(name);
        if (clazz != null) {
            if (resolve) {
                resolveClass(clazz);
            }
            //如果class类被修改过，则重新加载
            if (isModify(name)) {
                System.out.println("文件被修改需要重新加载......");
                hcl = new HotSwapURLClassLoader();
                clazz = customLoad(name, hcl);
            }
            return (clazz);
        }
//如果类的包名为"com."开始，则有系统默认加载器AppClassLoader加载
        if (name.startsWith("java.")) {
            try {
//得到系统默认的加载cl，即AppClassLoader
                ClassLoader system = ClassLoader.getSystemClassLoader();
                clazz = system.loadClass(name);
                if (clazz != null) {
                    if (resolve)
                        resolveClass(clazz);
                    return (clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return customLoad(name, this);
    }

    public Class customLoad(String name, ClassLoader cl) throws ClassNotFoundException {
        return customLoad(name, false, cl);
    }

    public Class customLoad(String name, boolean resolve, ClassLoader cl)
            throws ClassNotFoundException {
        //findClass()调用的是URLClassLoader里面重载了ClassLoader的findClass()方法
        Class clazz = ((HotSwapURLClassLoader) cl).findClass(name);
        if (resolve)
            ((HotSwapURLClassLoader) cl).resolveClass(clazz);
        //缓存加载class文件的最后修改时间
        long lastModifyTime = getClassLastModifyTime(name);
        cacheLastModifyTimeMap.put(name, lastModifyTime);
        return clazz;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        return super.findClass(name);
    }

    /**
     * 判断这个文件更上次是否修改过
     *
     * @param name
     * @return
     */
    private boolean isModify(String name) {
        long lastmodify = getClassLastModifyTime(name);
        long previousModifyTime = cacheLastModifyTimeMap.get(name);
        if (lastmodify > previousModifyTime) {
            return true;
        }
        return false;
    }

    /**
     * 获取文件最后修改时间
     * @param name
     * @return
     */
    private long getClassLastModifyTime(String name) {
        String path = getClassCompletePath(name);
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException(new FileNotFoundException(name));
        }
        return file.lastModified();
    }

    /**
     * 获取固定Class的文件
     *
     * @param name
     * @return
     */
    private String getClassCompletePath(String name) {
        String simpleName = name.substring(name.lastIndexOf(".") + 1);
        StringBuffer buffer = new StringBuffer();
        if (!projectClassPath.endsWith("/")) {
            buffer.append(projectClassPath).append(File.separator).append(packagePath);
        } else {
            buffer.append(projectClassPath).append(packagePath);
        }
        if (!packagePath.endsWith("/")) {
            buffer.append(File.separator).append(simpleName).append(".class");
        } else {
            buffer.append(simpleName).append(".class");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        URL[] url = getMyURLs();
        for (URL u : url) {
//file:/F:/diamond-304_workspace/viemall/WebRoot/WEB-INF/classes/
            System.out.println(u.toString());
        }
    }

}