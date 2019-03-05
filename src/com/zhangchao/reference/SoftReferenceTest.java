package com.zhangchao.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SoftReferenceTest {  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        A a = new A();  
        a.str = "Hello, reference";  
        SoftReference<A> sr = new SoftReference<A>(a);  
        a = null;  
        int i = 0;
        List<Object> list = new ArrayList<>();
        Properties props=System.getProperties(); //系统属性
        System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
        while (sr.get() != null) {
            System.out.println(String.format("Get str from object of SoftReference: %s, count: %d", sr.get().str, ++i));
            for(int j =0; j< 1000; j++) {
                list.add(new Object());
            }
            System.out.println(list.size());
//            if (i % 10 == 0) {
                System.gc();
                System.out.println("System.gc() was invoked!");
//            }
            try {  
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
  
            }

        }  
        System.out.println("object a was cleared by JVM!");  
    }  
  
}  