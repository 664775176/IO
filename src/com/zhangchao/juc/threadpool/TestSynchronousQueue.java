package com.zhangchao.juc.threadpool;

import java.util.concurrent.*;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestSynchronousQueue
 * @description: TODO
 * @date 2019/3/10 14:38
 */
public class TestSynchronousQueue {
    public static void main(String[] args) throws  Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });
    }
}
