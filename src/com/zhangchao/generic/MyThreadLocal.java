package com.zhangchao.generic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:MyThreadLocal
 * @description: TODO
 * @date 2019/1/29 16:42
 */
public class MyThreadLocal<T> {

    static List<?> fun(){
        List<?> list = null;
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list = list1;
        System.out.println(list.get(0));
//        list = new LinkedList<String>();
//        list.add("1");
        return list;
    }
    public static void main(String[] args)  {
        fun1(fun());

    }
    static class MyThreadLocalMap {
        static class Entry<T> extends WeakReference<ThreadLocal<T>> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal<T> k, Object v) {
                super(k);
                value = v;
            }
        }
    }

    static void fun1(List<?> list){
        Iterator<?> iterator = list.iterator();
//        System.out.println(list.get(0));
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }



}
