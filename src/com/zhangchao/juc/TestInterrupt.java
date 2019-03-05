package com.zhangchao.juc;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestInterrupt
 * @description: TODO
 * @date 2018/12/29 10:09
 */
public class TestInterrupt {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Runnable() {
            private int i = 0;
            @Override
            public void run() {
                while(Thread.interrupted()) {
                    i ++;
                }
            }
        });
        thread.start();
        Thread.sleep(100);
//        thread.interrupt();
    }

}
