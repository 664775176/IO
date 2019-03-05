package com.zhangchao.juc.threadpool;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestGet
 * @description: TODO
 * @date 2019/1/28 16:47
 */
public class TestGet {

    public static void main(String[] args) {
        FutureTask<Integer> i = new FutureTask<Integer>(new Runnable(){
            @Override
            public void run() {
                while (true){

                }
            }
        }, null);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    i.get();
                } catch (Exception e){
                }
            }
        } ,"runner1");
        t.start();
        try {
            Thread.sleep(100000);
//            i.get();

        } catch (Exception e){

        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    i.get(100,TimeUnit.SECONDS);
                } catch (Exception e){
                }
            }
        },"runner2");
        t1.start();
        try {
            Thread.sleep(100);
//            i.get();

        } catch (Exception e){

        }
//        i.cancel(true);
    }
}
