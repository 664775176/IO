package com.zhangchao.test;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestFinal
 * @description: TODO
 * @date 2018/12/19 18:51
 */
public class TestFinal {
    public static void test( String s){
//        final String s = "axman";
        ABSClass c = new ABSClass(){
            public void m(){
                int x = s.hashCode();
                System.out.println(x);
            }
        };
        //其它代码.
    }
}
interface ABSClass {

}
