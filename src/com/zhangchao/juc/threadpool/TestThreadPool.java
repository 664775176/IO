package com.zhangchao.juc.threadpool;

import jdk.nashorn.internal.ir.Block;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestThreadPool
 * @description: TODO
 * @date 2018/12/29 15:36
 */
public class TestThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 11, 0L,
                TimeUnit.MILLISECONDS, new MyArrayBlockingQueue<Runnable>(6) {
        });
//        executor.allowCoreThreadTimeOut(true);
//        Future f = new FutureTask(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("123");
//            }
//        }, null);
//        ((FutureTask) f).run();
//        try {
//            f.get();
//        } catch (Exception e){
//
//        }
        for(int i=0; i< 11; i++ ){
            Future future = executor.submit(new Runnable() {
                @Override
                public void run() {
                    while(true){

                    }
//                    int sum = 0;
//                   for(int j = 0; j< 100; j++){
//                       sum = sum + j;
//                   }
//                   try {
//                       Thread.sleep(100);
//                   } catch (InterruptedException e) {
//                       System.out.println("中断");
//                   }

//                   System.out.println(sum);
//                    try {
//                        queue.take();
//                    }catch (Exception e) {
//                        System.out.println("中断");
//                    }
                }

            });
        }
        executor.shutdown();
//        for(int i=0; i< 1; i++ ){
//            Future future = executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    while (true) {
//
//                    }
//                }
//            });
//        }
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("123");
//            }
//        });
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//
//        }
//        executor.shutdown();
//        System.out.println("end");
//        System.out.println(list.size());
//        try {
//            Thread.sleep(3000);
//        }catch (Exception e) {
//        }
    }
}
