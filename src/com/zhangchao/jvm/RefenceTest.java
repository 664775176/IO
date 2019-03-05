package com.zhangchao.jvm;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:RefenceTest
 * @description: TODO
 * @date 2018/12/5 14:42
 */
public class RefenceTest {

//    private volatile int array[] = {1, 2, 3};
    private volatile int a = 2;

    public static void main(String args[]) throws Exception{
        RefenceTest r = new RefenceTest();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                 r.array[1] = 3;
                 r.a = 3;
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                r.array[1] = 0;
                r.a = 0;
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(100);
//        System.out.println(r.array[1]);
        System.out.println(r.a);
    }
}
