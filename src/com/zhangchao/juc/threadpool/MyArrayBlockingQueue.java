package com.zhangchao.juc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:MyArrayBlockingQueue
 * @description: TODO
 * @date 2019/1/22 9:19
 */
public class MyArrayBlockingQueue<E> extends ArrayBlockingQueue<E> {

    public MyArrayBlockingQueue(int i){
        super(i);
    }

    @Override
    public E take()    {
        try {
//            System.out.println("execute take");
//            Thread.sleep(10000);
            return super.take();
        } catch (InterruptedException e){
            System.out.println("中断");
        }
        return null;
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        System.out.println("execute poll");
        return super.poll(timeout, unit);
    }
}
