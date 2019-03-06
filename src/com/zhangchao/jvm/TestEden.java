package com.zhangchao.jvm;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestEden
 * @description: TODO
 * @date 2019/3/5 15:47
 */
public class TestEden {
    private static   final  int _1MB = 1024 * 1024;
    public static void main(String args[]) throws Exception{
        new TestEden().fun();
    }
    public void fun(){
        byte []allocation1, allocation2, allocation3, allocation4, allocation5;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[1 * _1MB];
//        allocation5 = new byte[1/2 * _1MB];
        allocation5 = new byte[1 * _1MB];
//        allocation5 = new byte[1 * _1MB];
//        allocation4 = new byte[4 * _1MB];
    }
}
