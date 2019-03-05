package com.zhangchao.designpattern.observer;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Main
 * @description: TODO
 * @date 2018/11/15 19:34
 */
public class Main {
    public static void main(String args[]) {

        Observable observable = new Observable();
        Observer o = new Observer1();
        observable.addObserver(o);
        o = new Observer2();
        observable.addObserver(o);
        observable.modifyObserver();
    }
}
