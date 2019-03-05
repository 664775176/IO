package com.zhangchao.generic;

import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestGenerics
 * @description: TODO
 * @date 2019/1/29 16:36
 */
public class TestGenerics {
    public static void main(String[] args)  {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);

        Integer[] i = new Integer[10];
        Number[] n = new Integer[5];

        B<Integer> b1 = new B<Integer>();
        A<Integer> a1 = new A(threadLocal, 1);
//        A<Number> a2 = new A<Integer>(threadLocal,2);

    }



}
class B<T>{

}
class A<T> extends SoftReference<ThreadLocal<T>>{
    Object value;
    public A(ThreadLocal<T> key, Object value){
        super(key);
        this.value = value;
    }
}