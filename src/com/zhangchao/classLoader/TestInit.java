package com.zhangchao.classLoader;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestInit
 * @description: TODO
 * @date 2018/11/28 16:16
 */
public class TestInit {
    public  static int a ;
    static {
        System.out.println(a);
        System.out.println("init");
        a = 3;
        System.out.println(a);
    }
}
