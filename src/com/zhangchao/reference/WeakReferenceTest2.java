package com.zhangchao.reference;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:WeakReferenceTest2
 * @description: TODO
 * @date 2019/3/6 17:56
 */
public class WeakReferenceTest2 {
    public static void main(String[] args) {

    }

    class Entry {
        Object value;
        ThreadLocal<?> referent;
        Entry(ThreadLocal<?> k, Object v) {
            referent = k;
            value = v;
        }
    }
}
