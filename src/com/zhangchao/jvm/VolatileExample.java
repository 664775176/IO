package com.zhangchao.jvm;

class VolatileExample {
    int a = 0;
    int b = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;                   //1
        try {
            Thread.sleep(1000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;               //2
    }

    public void reader() {
        if (flag) {                //3
            b =  a;           //4
            System.out.println(Thread.currentThread() + ":" + b);
        }
        System.out.println(Thread.currentThread() + ":" + b);
    }

    public static  void main (String args[]){
        VolatileExample v = new VolatileExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                v.writer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                v.reader();
            }
        });
        thread1.start();
                try {
            thread1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread2.start();
        System.out.println(Thread.currentThread() + ":" + v.b);
    }
}
