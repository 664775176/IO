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
//        String str2 = new StringBuilder("Java(TM) SE ").append("Runtime Environment").toString();
//        System.out.println(str2.intern() == str2);
//        String str3 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str3.intern() == str3);

//        String str4 = "计算机软件";
//        System.out.println(str4.intern() == str4);
//        String str5 = "Java(TM) SE Runtime Environment";
//        System.out.println(str5.intern() == str5);
//        String str6 = "java";
//        System.out.println(str6.intern() == str6);

//        String s = new String("1");
//        String s2 = "1";
//        s.intern();
//        System.out.println(s == s2);
//
//        String s3 = new String("1") + new String("1");
//        String s4 = "11";
//        s3.intern();ServerConfig
//        System.out.println(s3 == s4);

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

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
