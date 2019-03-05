package com.zhangchao.juc.threadpool;

import java.util.concurrent.FutureTask;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestRun
 * @description: TODO
 * @date 2019/1/29 14:56
 */
public class TestRun {
    public static void main(String[] args) {
        FutureTask<Integer> i = new FutureTask<Integer>(new Runnable(){
            @Override
            public void run() {
                System.out.println("done");
            }
        }, 1);
        System.out.println("first run");
//        i.run();

        try {
            Thread.sleep(100);
        } catch (Exception e){

        }
        System.out.println("second run");
//        i.run();
        int j = 0;
        try {
            j = i.get();
        } catch (Exception e) {

        }
        System.out.println(j);
    }
}
