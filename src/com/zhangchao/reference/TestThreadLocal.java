package com.zhangchao.reference;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestThreadLocal
 * @description: TODO
 * @date 2019/3/5 10:12
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<Integer> i = new ThreadLocal<>();

        i.set(10);
        System.out.println(i.get());
        System.gc();
        fun();
    }

    public static void fun(){

    }
}
