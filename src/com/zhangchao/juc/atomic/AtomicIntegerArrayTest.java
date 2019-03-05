package com.zhangchao.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AtomicIntergerArrayTest
 * @description: TODO
 * @date 2018/12/19 18:56
 */
public class AtomicIntegerArrayTest {
    private static int threadCount=1000;
    private static CountDownLatch countDown=new CountDownLatch(threadCount);
    static int[] values=new int[10];
    static AtomicIntegerArray ai = new AtomicIntegerArray(values);
    private static class UnSafe implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                for(int j=0;j<10;j++){//所有元素+1
                    values[j]++;
                }
            }
            countDown.countDown();
        }
    }
    private static class  Synchronized implements Runnable {
        @Override
        public synchronized void run() {
            for(int i=0;i<100;i++){
                for(int j=0;j<10;j++){//所有元素+1
                    values[j]++;
                }
            }
            countDown.countDown();
        }
    }
    private static class Lock implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                for(int j=0;j<10;j++){//所有元素+1
                    ai.getAndIncrement(j);
                }
            }
            countDown.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads=new Thread[threadCount];
//        Runnable runnable = new Lock();
        for(int i=0;i<threadCount;i++){
            threads[i]=new Thread(new Lock());
        }
        for(int i=0;i<threadCount;i++){
            threads[i].start();;
        }
        countDown.await();
        for(int i=0;i<10;i++){
            System.out.print(ai.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.print(values[i]+" ");
        }
    }
}
