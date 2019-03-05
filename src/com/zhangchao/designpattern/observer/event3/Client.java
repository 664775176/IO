package com.zhangchao.designpattern.observer.event3;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Client
 * @description: TODO
 * @date 2018/11/16 14:03
 */
public class Client {

    public static void main(String args[]){
        Writer w1 = new Writer("w1");
        Writer w2 = new Writer("w2");

        Reader r1 = new Reader("r1");
        Reader r2 = new Reader("r2");
        Reader r3 = new Reader("r3");

        r1.subcribe("w1");
        r2.subcribe("w1");
        r2.subcribe("w2");
        r3.subcribe("w1");
        r3.subcribe("w2");
        w1.addNovel("JAVA");
        w2.addNovel("SCALA");
        r2.unSubcribe("w1");
        w1.addNovel("Spring");
        w2.addNovel("zk");
    }
}
