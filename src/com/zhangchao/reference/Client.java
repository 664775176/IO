package com.zhangchao.reference;

import java.lang.ref.WeakReference;

/**
 * Main class
 *
 * @author BrightLoong
 * @date 2018/5/24
 */
public class Client {
    public static void main(String[] args) {
//        Apple<String> a = new Apple("红富士");  //注意这里，如果有强引用引用Apple的话，那么a引用所持有的对象不会被回收
        Salad salad = new Salad(new Apple("红富士"));   //如果这里没有强引用的话，那么new Apple对应的对象将会被回收
        //通过WeakReference的get()方法获取Apple
        System.out.println("Apple:" + salad.get());
        System.gc();
        try {
            //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //如果为空，代表被回收了
        if (salad.get() == null) {
            System.out.println("clear Apple。");
        }
    }
}