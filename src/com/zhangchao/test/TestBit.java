package com.zhangchao.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestBit
 * @description: TODO
 * @date 2018/12/29 11:04
 */
public class TestBit {
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;
    private final BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100);

    public static void main(String args[]) {
        TestBit t = new TestBit();
//        t.fun(t);
//        t.ctl.incrementAndGet();
//        t.fun(t);
        t.ctl.set(SHUTDOWN);
        System.out.println(t.addWorker(null, true));
        System.out.println(workerCountOf(t.ctl.get()));
    }

    public void fun(TestBit t) {
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println(t.ctl.get());
        System.out.println(runStateOf(t.ctl.get()));
        System.out.println(workerCountOf(t.ctl.get()));
    }

    private boolean addWorker(Runnable firstTask, boolean core) {
        retry:
        for (; ; ) {
            int c = ctl.get();
            int rs = runStateOf(c);

            // Check if queue empty only if necessary.
            // 检查线程池状态，队列状态，以及 firstask ，拆开来看
            // 这段代码看起来异常的蛋疼,转换一下逻辑即
            //rs>= SHUTDOWN && (rs != SHUTDOWN || firstTask != null ||workQueue.isEmpty())
            // 总结起来就是 当前处于非 Running 状态,并且这三种情况
            // 1. 不是处于 SHUTDOWN 状态，不能再创建线程
            // 2. 有新的任务 (因为不能再接收新的任务)
            // 3. 阻塞队列中已经没有任务 (不需要再创建线程)
            if (rs >= SHUTDOWN &&
                    !(rs == SHUTDOWN &&
                            firstTask == null &&
                            !workQueue.isEmpty()))
                return false;
        }
    }
}

