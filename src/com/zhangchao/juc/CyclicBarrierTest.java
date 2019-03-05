package com.zhangchao.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:CyclicBarrierTest
 * @description: TODO
 * @date 2018/12/27 15:28
 */
public class CyclicBarrierTest {
    private static CyclicBarrier barrier = new CyclicBarrier(4);
    public static void main(String[] args)  {
        for(int i =0; i<5; i++) {
            Thread thread = new Thread(new MyRunnable(barrier));
            thread.start();
        }
        try {
            barrier.await();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread());
    }

    static class MyRunnable implements Runnable{
        private CyclicBarrier barrier;
        MyRunnable( CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            try {
                barrier.await();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
