package com.zhangchao.classLoader.classloader;

public interface IClassLoadStrategy
{    
    ClassLoader getClassLoader (ClassLoadContext ctx);    
} // 接口定义结束  