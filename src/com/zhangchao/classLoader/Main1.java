package com.zhangchao.classLoader;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Main1
 * @description: TODO
 * @date 2018/11/29 10:13
 */
public class Main1 {
    public static void main (String [] args) throws Exception
    {
        System.out.println ("String class: " + String.class);
        class$java$lang$String = int.class;
        System.out.println ("String class: " + String.class);
    }

    static Class class$java$lang$String;
}
