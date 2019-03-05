package com.zhangchao.classLoader.classloader;

public class ClassLoadContext
{    
    public final Class getCallerClass ()    
    {    
        return m_caller;    
    }    
        
    ClassLoadContext (final Class caller)    
    {    
            m_caller = caller;    
        }    
            
    private final Class m_caller;
} // 类定义结束  