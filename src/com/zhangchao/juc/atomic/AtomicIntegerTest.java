package com.zhangchao.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AutomicInteger
 * @description: TODO
 * @date 2018/12/19 15:03
 */
public class AtomicIntegerTest {
    private  static int j = 0;
    private static AtomicInteger a = new AtomicInteger(j);
    public static void  main(String args[]) throws Exception{
        Runnable runnable = new AtomicIntegerRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(j);

    }

    static class NoLockRunnable implements Runnable {
            @Override
            public  void run () {
                for(int i = 0;i<10000;i++)
                    j++;
        }
    }

    static class SynchronizedRunnable implements Runnable {
        @Override
        public synchronized void run () {
            for(int i = 0;i<10000;i++)
                j++;
        }
    }

    static class AtomicIntegerRunnable implements Runnable {
        @Override
        public  void run () {
            for(int i = 0;i<10000;i++)
            {
//                 a.getAndIncrement();
//                 j = a.get();
                j = a.incrementAndGet();
            }
        }
    }
}
