package com.zhangchao.juc;


import java.util.concurrent.locks.LockSupport;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:LockSupportTest
 * @description: TODO
 * @date 2018/12/28 10:45
 */
public class LockSupportTest {
    private static Object object = new Object();
    public static void main(String[] args) throws Exception {
//        TestLockSupport lockSupport = new TestLockSupport();
//        lockSupport.start();

		TestThread thread = new TestThread(object);
		thread.start();
    }
}
class TestLockSupport extends Thread {
    public void run() {
        System.out.println( "TestLockSupport.run()" );
        LockSupport.park(this);
    }
}
class TestThread extends Thread {
    private Object object;
    public TestThread(Object object) {
        this.object = object;
    }
    public void run() {
        System.out.println( "TestThread.run()" );
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
