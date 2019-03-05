package com.zhangchao.jvm;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestString
 * @description: TODO
 * @date 2018/12/4 9:08
 */
public class TestString1 {

    public static void main(String args[]){
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("Java(TM) SE ").append("Runtime Environment").toString();
//        String str2 = "java";
        System.out.println(str2.intern() == str2);


//        String str2 = new String("str")+new String("01");
//        str2.intern();
//        String str1 = "str01";
//        System.out.println(str2==str1);
//        System.out.println(str2.intern()==str1);
//        String str2 = new String("str")+new String("01");
//        String str1 = "str01";
//        System.out.println(str2.intern()==str1);
//        System.out.println(str2.intern()==str2.intern());
//        System.out.println(str2==str1);
    }
}
