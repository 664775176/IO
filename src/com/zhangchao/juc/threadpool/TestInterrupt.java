package com.zhangchao.juc.threadpool;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestInterrupt
 * @description: TODO
 * @date 2019/1/30 17:06
 */
public class TestInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(Thread.currentThread().isInterrupted()){
                        throw new RuntimeException();
                    }
                }
            }
        }, "test");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }
}
