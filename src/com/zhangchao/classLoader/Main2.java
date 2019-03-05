package com.zhangchao.classLoader;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Main2
 * @description: TODO
 * @date 2018/11/29 10:14
 */
public class Main2 {
    public static void main (String [] args) throws Exception
    {
        System.out.println ("String class: " + String.class);
        Main.class.getDeclaredField ("class$java$lang$String").set (null, int.class);
        System.out.println ("String class: " + String.class);
    }
    static Class class$java$lang$String;
}
