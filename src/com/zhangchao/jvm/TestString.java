package com.zhangchao.jvm;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestString
 * @description: TODO
 * @date 2018/12/4 9:08
 */
public class TestString {

    public static void main(String args[]){
        String s = "java";
        String s1 = "你好";

        StringBuilder sb = new StringBuilder();
        String s2 = sb.append("ja").append("va").toString();
        sb = new StringBuilder();
        String s3 = sb.append("你").append("好").toString();
        System.out.println(s == s2.intern());
        System.out.println(s1 == s3.intern());
    }
}
