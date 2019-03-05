package com.zhangchao.juc;

import java.lang.management.ManagementFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ThreadStatusTest
 * @description: TODO
 * @date 2018/12/28 14:23
 */
public class ThreadStatusTest {
    public static void main(String[] args) {
//        runnable();     // 1
//         blocked();      // 2
//         waiting();      // 3
//         timedWaiting(); // 4
        blockedByLock();
    }

    public static String pid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.split("@")[0];
    }

    public static void runnable() {
        new Thread("runnable") {
            public void run() {
                long i = 0;
                while (true) {
                    i++;
                }
            }
        }.start();

    }

    public static void blocked() {
        final Object lock = new Object();
        new Thread("blocked") {
            public void run() {
                synchronized (lock) {
                    System.out.println("i got lock, but don't release");
                    while(true){

                    }
//                    try {
//                        Thread.sleep(1000L * 1000);
//                    } catch (InterruptedException e) {
//                    }
                }
            }
        }.start();

        try { Thread.sleep(100); } catch (InterruptedException e) {}

        synchronized (lock) {
            while(true){

            }
//            try {
//                Thread.sleep(30 * 1000);
//            } catch (InterruptedException e) {
//            }
        }
    }

    public static void blockedByLock() {
        final Lock lock = new ReentrantLock();

        new Thread("blocked") {
            public void run() {
               lock.lock();
               try {
                   while(true){

                   }
               } finally {
                   lock.unlock();
               }
            }
        }.start();
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
        }
        lock.lock();
    }

    public static void timedWaiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait(30 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void waiting() {
        final Object lock = new Object();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
