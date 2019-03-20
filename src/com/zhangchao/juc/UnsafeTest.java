package com.zhangchao.juc;

import sun.misc.Unsafe;
import sun.misc.VM;
import sun.reflect.Reflection;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:UnsafeTest
 * @description: TODO
 * @date 2019/3/19 13:23
 */
public class UnsafeTest {
    public static void  main(String args[]) throws Exception{
        ClassLoader classLoader = UnsafeTest.class.getClassLoader().getParent();
        Class.forName("com.zhangchao.juc.MyUnsafe", true, classLoader);


    }


}
class MyUnsafe{
    static {
        try {
            Class<?> caller = Reflection.getCallerClass();
            System.out.println(caller.getClassLoader());
            System.out.println(VM.isSystemDomainLoader(caller.getClassLoader()));
            Unsafe unsafe = Unsafe.getUnsafe();
            long value = 0;
            final long valueOffset = unsafe.objectFieldOffset(MyUnsafe.class.getDeclaredField("value"));
            System.out.println(valueOffset);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
