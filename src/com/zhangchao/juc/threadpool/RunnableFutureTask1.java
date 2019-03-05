package com.zhangchao.juc.threadpool;

import java.util.concurrent.*;


/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:RunnableFutureTask1
 * @description: TODO
 * @date 2018/12/17 14:39
 */
public class RunnableFutureTask1 {

    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String args[]) {
        runnableDemo();
        callableDemo();
        runnableFuture();
        futureTaskExecutor();
        futureTaskResult();
        futureTask();
    }

    static void runnableDemo (){
        new Thread(() -> System.out.println("runnable demo : " + fibc(20))).start();
    }

    static void callableDemo() {
        try {
            Future future = executor.submit(() -> fibc(20));
            System.out.println("callable demo : " + future.get());
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    static void runnableFuture() {
        try {
            Future future = executor.submit(()->fibc(20), 1);
            System.out.println("runnable future demo : " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void futureTaskExecutor(){
        try {
            FutureTask futureTask = new FutureTask<Integer>(
                    new Callable<Integer>() {
                        @Override
                        public Integer call() throws Exception {
                            return fibc(20);
                        }
                    }
            );
            executor.submit(futureTask);
            System.out.println("runnable future demo : " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void futureTaskResult(){
        try {
            FutureTask futureTask = new FutureTask<Integer>(
                    ()-> fibc(20), 1
            );
            executor.submit(futureTask);
            System.out.println("runnable future demo : " + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void futureTask(){
        FutureTask futureTask = new FutureTask<Integer>(
                ()-> fibc(20), 1
        );
        new Thread(futureTask).start();
    }



    public static int fibc(int i) {
        if(i < 0)
            throw new RuntimeException("error");
        if (i == 0)
            return 0;
        else if(i == 1)
            return 1;
        else
            return fibc(i-1) + fibc(i-2);
    }
}
